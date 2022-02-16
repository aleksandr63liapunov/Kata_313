package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Security;


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

    @GetMapping("/admin")
    public String showAllUsers(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("admen", user);
        model.addAttribute("mans", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/user")
    public String showUserForUser (Model userModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userModel.addAttribute("man", user);
        return "user";
    }

    //------------------------------------------------------------------------------------------------------------------

    @GetMapping("/new")
    public String newUserPage(@ModelAttribute("userBoy") User user, Model model) {
        model.addAttribute("setRoles", userService.getRoles());
        return "new";
    }

    @PostMapping("/admin/create")
    public String createUser(@ModelAttribute("user") User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:admin";
    }

    @GetMapping("/edit/{id}")
    public String editeUserPage(@PathVariable Long id, Model userModel) {
        userModel.addAttribute("userUpdate", userService.getUser(id));
        userModel.addAttribute("userRoles", userService.getRoles());
        return "redirect:admin";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:admin/users";
    }
}
