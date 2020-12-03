package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthor();

    Author findAuthorById(long id);

    void saveAuthor(Author author);

    void deleteAuthorById(long id);

    void newAuthor(Author author);
}
