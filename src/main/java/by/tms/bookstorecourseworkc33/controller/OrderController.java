package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.Book;
import by.tms.bookstorecourseworkc33.entity.Order;
import by.tms.bookstorecourseworkc33.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(path = "order")
public class OrderController {
    private final BookService bookService;

    public OrderController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String index() {
        return "/order";
    }

    @GetMapping(path = "buy/{id}")
    public String buy(@PathVariable("id") long id, HttpSession httpSession) {
        if (httpSession.getAttribute("cart") == null) {
            List<Order> cart = new ArrayList<>();
            cart.add(new Order((List<Book>) bookService.findBookById(id), 1));
            httpSession.setAttribute("cart", cart);
        } else {
            List<Order> cart = (List<Order>) httpSession.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Order((List<Book>) bookService.findBookById(id), 1));
            } else {
                int quantity = cart.get(index).getCount() + 1;
                cart.get(index).setCount(quantity);
            }
            httpSession.setAttribute("cart", cart);
        }
        return "redirect:/order";
    }

    private int exists(long id, List<Order> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (Objects.equals(cart.get(i).getBook().get(i).getId(), id)) {
                return i;
            }
        }
        return -1;
    }

    @GetMapping(path = "remove/{id}")
    public String remove(@PathVariable("id") long id, HttpSession session) {
        List<Order> cart = (List<Order>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:/order";
    }
}
