package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
