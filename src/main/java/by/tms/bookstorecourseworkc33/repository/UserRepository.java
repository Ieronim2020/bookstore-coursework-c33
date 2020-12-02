package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findById(long id);

    List<User> findAllById(long id);

}
