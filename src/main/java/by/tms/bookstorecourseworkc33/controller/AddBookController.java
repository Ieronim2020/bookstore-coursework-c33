package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.Author;
import by.tms.bookstorecourseworkc33.entity.Book;
import by.tms.bookstorecourseworkc33.entity.dto.AuthorDto;
import by.tms.bookstorecourseworkc33.entity.dto.BookDto;
import by.tms.bookstorecourseworkc33.service.AuthorService;
import by.tms.bookstorecourseworkc33.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/book")
public class AddBookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public AddBookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ModelAndView listBook(ModelAndView modelAndView) {
        modelAndView.addObject("books", bookService.getBooks());
        modelAndView.addObject("authors", authorService.getAuthor());
        modelAndView.setViewName("newBook");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ModelAndView getAllUsers(@PathVariable("id") long id, ModelAndView modelAndView) {
        Book findBook = bookService.findBookById(id);
        modelAndView.addObject("findBook", findBook);
        Author findAuthor = authorService.findAuthorById(id);
        modelAndView.addObject("findAuthor", findAuthor);
        modelAndView.addObject("bookUpdate", new BookDto());
        modelAndView.addObject("authorUpdate", new AuthorDto());
        modelAndView.setViewName("bookEdit");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{id}")
    public ModelAndView updateBook(@ModelAttribute("bookUpdate") BookDto bookDto, @ModelAttribute("bookUpdate") AuthorDto authorDto, @PathVariable("id") long id, ModelAndView modelAndView) {
        Book book = new Book();
        book.setNameBook(bookDto.getNameBook());
        book.setPrice(bookDto.getPrice());
        book.setQuantityPage(bookDto.getQuantityPage());
        book.setYear(bookDto.getYear());
        bookService.updateBook(id, book);
//        Author author = new Author();
//        author.setFirstName(authorDto.getFirstName());
//        author.setLastName(authorDto.getLastName());
//        authorService.updateAuthor(author);
        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/book/{id}")
    public ModelAndView deleteBook(@PathVariable("id") long id, ModelAndView modelAndView) {
        bookService.deleteBookById(id);
        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }
}
