package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findById(long id);
}
