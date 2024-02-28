package be.thomasmore.gunranch.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        String name = "Bullseye Shooting Academy";
        String slogan = "Lock Load, and Hit the Bullseye";
        model.addAttribute("name", name);
        model.addAttribute("slogan", slogan);
        return "home";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model) {
        model.addAttribute("model",model);
        return "about-us";
    }
    @GetMapping("/contact")
    public String contactUs(Model model){
        String phoneNumber = "0494 31 00 04";
        String emailAdres = "owentm031111@gmail.com";
        String adres = "Duivebergen 2B 3140 Keerbergen";
        model.addAttribute("model",model);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("emailAdres",emailAdres);
        model.addAttribute("adres",adres);
        return "contact";
    }

}
