package com.example.projectmanager.controller;

import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.service.RetailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RetailerController {


    private final RetailerService retailerService;

    @GetMapping("/login")
    public String login(){
        return "loginForm";
    }

    @GetMapping("/registration")
    public String registration(){
        return "/registrationpage";
    }

    @PostMapping("/registration")
    public String createRetailer(Retailer retailer, Model model) {
        if (!retailerService.createRetailer(retailer)) {
            model.addAttribute("errorMessage", "Retailer with SUCH login: " + retailer.getLogin() + "exist! ");
            return "registration";
        }
        return "redirect:/loginForm";
    }



}
