package be.thomasmore.gunranch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model){
        String firstName = "Owen";
        String lastName = "Talboom";
        String emailAdres = "owentm031111@gmail.com";
        String phoneNumber = "0494 31 00 04";
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("emailAdres",emailAdres);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("model",model);
        return "login";
    }
}
