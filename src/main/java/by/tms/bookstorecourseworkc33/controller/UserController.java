package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.entity.dto.UserDto;
import by.tms.bookstorecourseworkc33.service.UserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public ModelAndView listUserAuth(@AuthenticationPrincipal User user, ModelAndView modelAndView) {
        List<User> findUser = userService.loadUserById(user.getId());
        modelAndView.addObject("userAuth", findUser);
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/{id}")
    public ModelAndView getUserAuth(@PathVariable("id") long id, ModelAndView modelAndView) {
        User findUser = userService.findUserById(id);
        modelAndView.addObject("findUser", findUser);
        modelAndView.addObject("userUpdate", new UserDto());
        modelAndView.setViewName("userEdit");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/{id}")
    public ModelAndView updateUserAuth(@ModelAttribute("userUpdate") UserDto userDto, @PathVariable("id") long id, ModelAndView modelAndView) {
        userService.updateProfile(id, userDto);
        User findUser = userService.findUserById(id);
        modelAndView.addObject("allUsers", findUser);
        modelAndView.addObject("userUpdate", new UserDto());
        modelAndView.setViewName("redirect:/user");
        return modelAndView;
    }
}
