package com.mushroom.travel_agency.controller;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    private final Environment environment;

    public AuthController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/login")
    public String login(String error, String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", environment.getProperty("error.login"));
        }
        if (logout != null) {
            model.addAttribute("message", environment.getProperty("message.logout"));
        }
        return "login";
    }
}
