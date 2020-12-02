package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthor();

    void saveAuthor(Author author);

    Author findAuthorById(long id);

    void updateAuthor(Author author);
}
