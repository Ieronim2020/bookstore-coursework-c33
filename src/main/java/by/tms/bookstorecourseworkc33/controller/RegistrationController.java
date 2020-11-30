package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.user.dto.UserDto;
import by.tms.bookstorecourseworkc33.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class RegistrationController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/registration")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("userReg", new UserDto());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@ModelAttribute("userReg") UserDto userDto, ModelAndView modelAndView) {
        userService.saveRegUser(userDto);
        modelAndView.setViewName("redirect:/auth/login");
        return modelAndView;
    }
}
