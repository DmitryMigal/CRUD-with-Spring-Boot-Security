package ru.Migal.SecurityCRUD.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.Migal.SecurityCRUD.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping(value = "/")
    public String userPage(@AuthenticationPrincipal User user, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("roles", user.getRoles());
        return "user";
    }
}
