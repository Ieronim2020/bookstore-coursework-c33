package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Book;
import by.tms.bookstorecourseworkc33.entity.dto.BookDto;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book findBookById(long id);

    void updateBook(long id, BookDto bookDto);

    void deleteBookById(long id);

    void saveBook(Book book);
}
