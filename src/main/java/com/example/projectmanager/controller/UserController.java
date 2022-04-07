package com.example.projectmanager.controller;

import com.example.projectmanager.entity.User;
import com.example.projectmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "loginForm";
    }

    @GetMapping("/registration")
    public String registration(){
        return "/registrationpage";
    }

    @PostMapping("/registration")
    public String createRetailer(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Retailer with SUCH login: " + user.getLogin() + "exist! ");
            return "registration";
        }
        return "redirect:/loginForm";
    }



}
