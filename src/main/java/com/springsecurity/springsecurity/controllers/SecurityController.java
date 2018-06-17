package com.springsecurity.springsecurity.controllers;

import com.springsecurity.springsecurity.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SecurityController {

    private final UserService userService;

    @Autowired
    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String user(@RequestParam(name="users", required=false) String users, Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("current", userService.currentUser());
        return "user";
    }

    @GetMapping("admin")
    public String admin(@RequestParam(name="users", required=false) String users, Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin";
    }

    @GetMapping("access-denied")
    public String accessDenied(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "access-denied";
    }

    @GetMapping("/block/{userName}")
    public String blockUser(@PathVariable String userName) {
        userService.updateUserState(userName);

        return "redirect:/admin";
    }

    @GetMapping("/delete/{userName}")
    public String deleteUser(@PathVariable String userName) {
        userService.deleteUser(userName);

        return "redirect:/admin";
    }
}
