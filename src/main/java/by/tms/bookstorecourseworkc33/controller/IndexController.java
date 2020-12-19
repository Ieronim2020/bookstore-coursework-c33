package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.service.AuthorService;
import by.tms.bookstorecourseworkc33.service.AuthorServiceImpl;
import by.tms.bookstorecourseworkc33.service.BookService;
import by.tms.bookstorecourseworkc33.service.BookServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class IndexController {
    private final BookService bookService;
    private final AuthorService authorService;

    public IndexController(BookServiceImpl bookService, AuthorServiceImpl authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public ModelAndView index(@AuthenticationPrincipal User user, ModelAndView modelAndView) {
        modelAndView.addObject("users", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(path = "/userBookList")
    public ModelAndView listBook(ModelAndView modelAndView) {
        modelAndView.addObject("books", bookService.getBooks());
        modelAndView.setViewName("userBookList");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("filter")
    public ModelAndView filter(@RequestParam String filter, ModelAndView modelAndView) {
        if (filter != null && !filter.isEmpty()) {
            modelAndView.addObject("books", bookService.findByNameBook(filter, filter, filter));
        } else {
            modelAndView.addObject("books", bookService.getBooks());
        }
        modelAndView.setViewName("userBookList");
        return modelAndView;
    }
}
