package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Book;
import by.tms.bookstorecourseworkc33.entity.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> getBooks(Pageable pageable);

    Book findBookById(long id);

    void updateBook(long id, BookDto bookDto);

    void deleteBookById(long id);

    void saveBook(Book book);

    Page<Book> findByNameBook(String nameBook, String firstName, String lastName, Pageable pageable);
}
