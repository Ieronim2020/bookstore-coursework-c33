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
@RequestMapping(path = "/admin")
public class AdminController {

    private final UserServiceImpl userService;

    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ModelAndView usersList(@AuthenticationPrincipal User user, ModelAndView modelAndView) {
        List<User> findAllUsersUsers = userService.findAll(user);
        modelAndView.addObject("users", findAllUsersUsers);
        modelAndView.setViewName("adminList");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ModelAndView getAllUsers(@PathVariable("id") long id, ModelAndView modelAndView) {
        User findUser = userService.findUserById(id);
        modelAndView.addObject("findUser", findUser);
        modelAndView.addObject("userUpdate", new UserDto());
        modelAndView.setViewName("adminEdit");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{id}")
    public ModelAndView updateUser(@ModelAttribute("userUpdate") UserDto userDto, @PathVariable("id") long id, ModelAndView modelAndView) {
        userService.updateProfile(id, userDto);
        User findUser = userService.findUserById(id);
        modelAndView.addObject("allUsers", findUser);
        modelAndView.addObject("userUpdate", new UserDto());
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id, ModelAndView modelAndView) {
        userService.deleteUserById(id);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }
}
