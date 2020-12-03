package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Author;
import by.tms.bookstorecourseworkc33.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void newAuthor(Author author) {
        authorRepository.saveAndFlush(author);
    }
}
