package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.dto.UserDto;
import by.tms.bookstorecourseworkc33.entity.user.Role;
import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
@RequestMapping(path = "/")
public class RegistrationController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("userReg", new UserDto());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@ModelAttribute("userReg") UserDto userDto, ModelAndView modelAndView) {
        User user = new User();
        user.setEmail(userDto.getEmailDto());
        String encodedPassword = passwordEncoder.encode(userDto.getPasswordDto());
        user.setPassword(encodedPassword);
        user.setUsername(userDto.getUsernameDto());
        user.setRoles(Collections.singleton(Role.USER));
        userService.saveRegUser(user);
        modelAndView.setViewName("redirect:/auth/success");
        return modelAndView;
    }
}
