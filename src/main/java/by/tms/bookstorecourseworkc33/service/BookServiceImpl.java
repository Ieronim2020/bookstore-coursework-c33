package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.Book;
import by.tms.bookstorecourseworkc33.repository.BookRepository;
import by.tms.bookstorecourseworkc33.service.exception.NoBookWithIdException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @PersistenceContext
    private EntityManager entityManager;
    private final BookRepository bookRepository;

    public BookServiceImpl(EntityManager entityManager, BookRepository bookRepository) {
        this.entityManager = entityManager;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBookById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(long id, Book book) {
        Book bookFromDb = bookRepository.findById(id);
        if (bookFromDb != null) {
            bookRepository.save(book);
        } else throw new NoBookWithIdException();
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateUser(Book book){
        entityManager.merge(book);
    }
}
