package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.entity.user.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll(User user);

    User findUserById(long id);

    void saveRegUser(UserDto user);

    void updateProfile(long id, UserDto user);
}
