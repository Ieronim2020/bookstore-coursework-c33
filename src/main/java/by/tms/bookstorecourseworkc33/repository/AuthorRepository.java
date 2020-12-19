package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findById(long id);
    List<Author> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}