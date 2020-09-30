package com.mushroom.travel_agency.controller;

import com.mushroom.travel_agency.entity.Role;
import com.mushroom.travel_agency.entity.User;
import com.mushroom.travel_agency.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String userDetails(@PathVariable Long id, Model model) {
        User user = userService.getById(id);

        List<Role> roles = user.getRoles();
        model.addAttribute("isManager", roles.stream()
            .anyMatch(role -> role.getName().equals("MANAGER")));

        model.addAttribute("user", user);
        return "user_details";
    }

    @PostMapping("/edit/{id}")
    public String changeStatus(@PathVariable Long id) {
        User user = userService.getById(id);
        userService.changeRole("MANAGER", user);
        return "redirect:/users/edit/" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}


