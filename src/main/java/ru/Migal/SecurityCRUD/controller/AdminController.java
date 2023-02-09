package ru.Migal.SecurityCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.Migal.SecurityCRUD.model.User;
import ru.Migal.SecurityCRUD.service.RoleService;
import ru.Migal.SecurityCRUD.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping(value = "/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "admin-page";
    }

    @GetMapping(value = "/add-user")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "new-user";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("users") User user, @RequestParam(required = false, value = "checkBoxRoles")
    String[] checkBoxRoles) {
        user.setRoles(roleService.checkRoles(checkBoxRoles));
        userService.addUser(user);
        return "redirect:/admin/";
    }

    @GetMapping(value = "/{id}/delete-user")
    public String deleteUserQuestion(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("users", userService.getUserById(id));
        return "delete-user";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@ModelAttribute("users") User user) {
        userService.deleteUser(user);
        return "redirect:/admin/";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("users", userService.getUserById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "edit";
    }

    @PatchMapping(value = "/{id}")
    public String updateUser(@ModelAttribute("users") User user, @RequestParam(required = false, value = "checkBoxRoles")
    String[] checkBoxRoles) {
        user.setRoles(roleService.checkRoles(checkBoxRoles));
        userService.updateUser(user);
        return "redirect:/admin/";
    }

}