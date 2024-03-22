package be.thomasmore.gunranch.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        final String loginName = principal != null ? principal.getName() : null;
        logger.info("homepage - logged in as" + loginName);
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


}
