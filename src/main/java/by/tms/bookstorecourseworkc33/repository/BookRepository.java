package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
