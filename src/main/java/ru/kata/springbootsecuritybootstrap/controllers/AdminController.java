package ru.kata.springbootsecuritybootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.springbootsecuritybootstrap.models.Role;
import ru.kata.springbootsecuritybootstrap.models.User;
import ru.kata.springbootsecuritybootstrap.services.RoleService;
import ru.kata.springbootsecuritybootstrap.services.UserService;

import java.util.Set;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin/")
    public String admin(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        model.addAttribute("admin", userService.oneUser());
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("admin", userService.oneUser());
        model.addAttribute("allRoles", roleService.findAll());
        return "newUser";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user, @RequestParam("role") Set<Role> roles) {
        userService.save(userService.createUser(user, roles));
        return "redirect:/admin/";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/admin/";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam("id") long id,
                         @RequestParam(value = "role", required = false) Set<Role> roles) {
        userService.update(id, userService.updateUser(user, roles, id));
        return "redirect:/admin/";
    }

    @GetMapping("/user/admin")
    public String user(Model model) {
        model.addAttribute("user", userService.oneUser());
        return "oneUserAdmin";
    }
}
