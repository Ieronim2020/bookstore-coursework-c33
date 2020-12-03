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
        modelAndView.setViewName("bookList");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ModelAndView getAllUsers(@PathVariable("id") long id, ModelAndView modelAndView) {
        Book findBook = bookService.findBookById(id);
        modelAndView.addObject("findBook", findBook);
        Author findAuthor = authorService.findAuthorById(findBook.getId());
        modelAndView.addObject("findAuthor", findAuthor);
        modelAndView.addObject("bookUpdate", new BookDto());
        modelAndView.addObject("authorUpdate", new AuthorDto());
        modelAndView.setViewName("bookEdit");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{id}")
    public ModelAndView updateBook(@ModelAttribute("bookUpdate") BookDto bookDto, @ModelAttribute("authorUpdate") AuthorDto authorDto, @PathVariable("id") long id, ModelAndView modelAndView) {
        Author author = new Author();
        author.setId(id);
        author.setFirstName(authorDto.getFirstNameDto());
        author.setLastName(authorDto.getLastNameDto());
        author.setBook(bookService.findBookById(id));
        authorService.saveAuthor(author);
        bookService.updateBook(id, bookDto);
        Book findBook = bookService.findBookById(id);
        modelAndView.addObject("findBook", findBook);
        Author findAuthor = authorService.findAuthorById(findBook.getId());
        modelAndView.addObject("findAuthor", findAuthor);
        modelAndView.addObject("bookUpdate", new BookDto());
        modelAndView.addObject("authorUpdate", new AuthorDto());
        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public ModelAndView deleteBook(@PathVariable("id") long id, ModelAndView modelAndView) {
        Book findBook = bookService.findBookById(id);
        modelAndView.addObject("findBook", findBook);
        authorService.deleteAuthorById(findBook.getId());
        bookService.deleteBookById(id);
        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }

    @GetMapping("/newBook")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("books", new BookDto());
        modelAndView.addObject("authors", new AuthorDto());
        modelAndView.setViewName("newBook");
        return modelAndView;
    }

    @PostMapping("/newBook")
    public ModelAndView addUser(@ModelAttribute("books") BookDto bookDto, @ModelAttribute("authors") AuthorDto authorDto, long id, ModelAndView modelAndView) {
        Book book = new Book();
        book.setId(id);
        book.setNameBook(bookDto.getNameBookDto());
        book.setPrice(bookDto.getPriceDto());
        book.setQuantityPage(bookDto.getQuantityPageDto());
        book.setYear(bookDto.getYearDto());
        Author author = new Author();
        author.setFirstName(authorDto.getFirstNameDto());
        author.setLastName(authorDto.getLastNameDto());
//        author.setBook();
        authorService.saveAuthor(author);
        book.setAuthors(bookDto.getAuthors());
        bookService.saveBook(book);
        modelAndView.setViewName("redirect:/book");
        return modelAndView;
    }
}
