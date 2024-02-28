package be.thomasmore.gunranch.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("Model",model);
        return "login";
    }

    @GetMapping("/reservation")
    public String reservations(Model model){
        model.addAttribute("model",model);
        return "reservation";
    }
}
