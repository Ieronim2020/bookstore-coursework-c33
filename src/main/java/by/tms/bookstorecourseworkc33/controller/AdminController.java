package by.tms.bookstorecourseworkc33.controller;

import by.tms.bookstorecourseworkc33.entity.dto.UserDto;
import by.tms.bookstorecourseworkc33.entity.user.User;
import by.tms.bookstorecourseworkc33.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ModelAndView allUsersList(@PageableDefault(size = 1) Pageable pageable, ModelAndView modelAndView) {
        modelAndView.addObject("users", userService.findAll(pageable));
        modelAndView.setViewName("adminList");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("filter")
    public ModelAndView filter(@RequestParam String filter, @PageableDefault(size = 1) Pageable pageable, ModelAndView modelAndView) {
        if (filter != null && !filter.isEmpty()) {
            modelAndView.addObject("users", userService.findByUsernameOrEmail(filter, filter, pageable));
        } else {
            modelAndView.addObject("users", userService.findAll(pageable));
        }
        modelAndView.setViewName("adminList");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ModelAndView getUser(@PathVariable("id") long id, ModelAndView modelAndView) {
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
        modelAndView.addObject("findUser", findUser);
        modelAndView.addObject("userUpdate", new UserDto());
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") long id, ModelAndView modelAndView) {
        userService.deleteUserById(id);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }
}
