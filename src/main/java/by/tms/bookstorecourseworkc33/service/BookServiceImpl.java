package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Book;
import by.tms.bookstorecourseworkc33.entity.dto.BookDto;
import by.tms.bookstorecourseworkc33.repository.BookRepository;
import by.tms.bookstorecourseworkc33.service.exception.NoBookWithIdException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(long id, BookDto bookDto) {
        Book bookFromDb = bookRepository.findById(id);
        if (bookFromDb != null) {
            Book books = new Book();
            books.setId(id);
            books.setNameBook(bookDto.getNameBookDto());
            books.setPrice(bookDto.getPriceDto());
            books.setQuantityPage(bookDto.getQuantityPageDto());
            books.setYear(bookDto.getYearDto());
            books.setAuthors(bookDto.getAuthors());
            bookRepository.save(books);
        } else throw new NoBookWithIdException();
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> findByNameBook(String nameBook) {
        return bookRepository.findByNameBookContainingIgnoreCase(nameBook);
    }
}
