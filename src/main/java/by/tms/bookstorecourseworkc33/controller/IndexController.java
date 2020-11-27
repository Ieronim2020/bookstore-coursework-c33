package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.service.BookServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class IndexController {
    private final BookServiceImpl bookServiceImpl;
//    private final AuthorServiceImpl authorServiceImpl;

    public IndexController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;

    }

    @GetMapping
    public ModelAndView index(@AuthenticationPrincipal User user, ModelAndView modelAndView) {
        modelAndView.addObject("user" , user);
        modelAndView.addObject("books", bookServiceImpl.getBooks());
//        modelAndView.addObject("authors", authorServiceImpl.getAuthor());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
