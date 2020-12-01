package by.tms.bookstorecourseworkc33.service;

import by.tms.bookstorecourseworkc33.entity.user.Role;
import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.entity.user.dto.UserDto;
import by.tms.bookstorecourseworkc33.repository.UserRepository;
import by.tms.bookstorecourseworkc33.service.exception.UserIsAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> loadUserById(long id) {
        return userRepository.findAllById(id);
    }

    @Override
    public List<User> findAll(User user) {
        return userRepository.findAll();
    }

    @Override
    public void saveRegUser(User user) {
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb == null) {
            userRepository.save(user);
        } else throw new UserIsAlreadyRegisteredException();
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

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
