package mk.finki.ukim.mk.wezba1.web.controller;

import mk.finki.ukim.mk.wezba1.model.User;
import mk.finki.ukim.mk.wezba1.model.enumerations.Role;
import mk.finki.ukim.mk.wezba1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String register(Model model) {
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password ,
                           @RequestParam String repeatPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam Role role
                          ) {

        try {
            this.userService.register(username, password, repeatPassword, name, surname, role);
            return "redirect:/login";
        }catch (Exception e) {
            return "redirect:/register?error=" + e.getMessage();
        }

    }
}
