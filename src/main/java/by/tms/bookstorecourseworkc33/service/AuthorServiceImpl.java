package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Author;
import by.tms.bookstorecourseworkc33.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }
}
