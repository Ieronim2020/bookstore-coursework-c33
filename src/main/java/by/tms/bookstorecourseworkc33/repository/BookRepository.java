package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);

    List<Book> findByNameBookContainingAllIgnoreCaseOrAuthorsIgnoreCase_FirstNameOrAuthorsIgnoreCase_LastName(String nameBook, String firstName, String lastName);
}
