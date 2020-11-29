package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}