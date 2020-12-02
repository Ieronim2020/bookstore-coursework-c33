package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    void saveBook(Book book);

    Book findBookById(long id);

    void updateBook(long id, Book book);

    void deleteBookById(long id);
    void updateUser(Book book);
}
