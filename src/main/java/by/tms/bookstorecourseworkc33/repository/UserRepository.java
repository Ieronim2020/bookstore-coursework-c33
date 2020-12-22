package by.tms.bookstorecourseworkc33.repository;

import by.tms.bookstorecourseworkc33.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findById(long id);

    List<User> findAllById(long id);

    Page<User> findAll(Pageable pageable);

}