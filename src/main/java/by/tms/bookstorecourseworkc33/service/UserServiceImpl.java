package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.user.Role;
import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.entity.user.dto.UserDto;
import by.tms.bookstorecourseworkc33.repository.UserRepository;

import by.tms.bookstorecourseworkc33.service.exception.SuchUserIsAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public List<User> findAll(User user) {
        List<User> findAllUsers = userRepository.findAll();
        return findAllUsers;
    }

    @Override
    public void saveRegUser(UserDto userDto) {
        User userFromDb = userRepository.findByEmail(userDto.getEmailDto());
        if (userFromDb == null) {
            User userReg = new User();
            userReg.setEmail(userDto.getEmailDto());
            userReg.setPassword(passwordEncoder.encode(userDto.getPasswordDto()));
            userReg.setUsername(userDto.getUsernameDto());
            userReg.setRoles(Collections.singleton(Role.USER));
            userRepository.save(userReg);
        } else throw new SuchUserIsAlreadyRegisteredException();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateProfile(long id, UserDto userDto) {
        User userFromDb = userRepository.findById(id);
        if (userFromDb != null) {
            User users = new User();
            users.setId(id);
            users.setEmail(userDto.getEmailDto());
            users.setPassword(passwordEncoder.encode(userDto.getPasswordDto()));
            users.setUsername(userDto.getUsernameDto());
            users.setRoles(Set.of(Role.values()));
            userRepository.save(users);
        }
    }
}
