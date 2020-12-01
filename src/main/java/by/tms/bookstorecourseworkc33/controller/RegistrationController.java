package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.user.Role;
import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.entity.user.dto.UserDto;
import by.tms.bookstorecourseworkc33.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
