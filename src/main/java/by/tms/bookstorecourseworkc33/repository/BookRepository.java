package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(long id);

    Page<Book> findByNameBookContainingAllIgnoreCaseOrAuthorsIgnoreCase_FirstNameOrAuthorsIgnoreCase_LastName(String nameBook, String firstName, String lastName, Pageable pageable);

    Page<Book> findAll(Pageable pageable);
}
