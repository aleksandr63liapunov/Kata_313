package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;


@Controller
@RequestMapping()
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @GetMapping("/")
    public String toLogin() {
        return "redirect:/login";
    }
    @GetMapping("/user")
    public String toUser() {
        return "redirect:/login";
    }

    @GetMapping("admin/users")
    public String showAllUsers(Model model) {
        model.addAttribute("people", userService.getAllUsers());
        return "users";
    }

    @GetMapping("admin/user/{id}")
    public String showUserForAdmin(@PathVariable("id") Long id, Model userModel) {
        userModel.addAttribute("man", userService.getUser(id));
        return "user";
    }

    @GetMapping("/user/{login}")
    public String showUserForUser (@PathVariable("login") String login, Model userModel) {
        userModel.addAttribute("man", userService.loadUserByUsername(login));
        return "user";
    }

    @GetMapping("/new")
    public String newUserPage(@ModelAttribute("userBoy") User user, Model model) {
        model.addAttribute("setRoles", userService.getRoles());
        return "new";
    }

    @PostMapping("admin/users")
    public String createUser(@ModelAttribute("user") User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}/edit")
    public String editeUserPage(@PathVariable Long id, Model userModel) {
        userModel.addAttribute("userUpdate", userService.getUser(id));
        userModel.addAttribute("userRoles", userService.getRoles());
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:admin/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:admin/users";
    }
}
