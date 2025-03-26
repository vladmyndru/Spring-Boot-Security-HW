package com.example.Spring_Boot_Security_HW.controller;


import com.example.Spring_Boot_Security_HW.dto.UserDto;
import com.example.Spring_Boot_Security_HW.entity.User;
import com.example.Spring_Boot_Security_HW.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("title", "LogIn");
        return "login";
    }

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("title", "Register");
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", "email error",
                    "The email already exists");
        }
        if (result.hasErrors()) {
            model.addAttribute("title", "Register");
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("title", "Users");
        model.addAttribute("users", users);
        return "users";
    }
}
