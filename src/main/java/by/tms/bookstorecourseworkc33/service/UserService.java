package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.entity.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    Page<User> findAll(Pageable pageable);

    User findUserById(long id);

    void saveRegUser(User user);

    void updateProfile(long id, UserDto user);

    void deleteUserById(long id);

    List<User> loadUserById(long id);

    User loadUserByUsername(String username);

    User findUserByEmail(String email);
}
