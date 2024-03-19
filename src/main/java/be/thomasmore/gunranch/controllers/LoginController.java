package be.thomasmore.gunranch.controllers;

import jakarta.servlet.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model,String userName, String passWord){
        model.addAttribute("userName",userName);
        model.addAttribute("passWord",passWord);
        return "login";
    }
    @GetMapping("/registration")
    public String registration(Model model, String firstName,
                               String lastName,
                               String emailAddress,
                               String phoneNumber,
                               String passWord,
                               String address,
                               String city,
                               String ssId,
                               String postalCode){
        
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("emailAddress",emailAddress);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("passWord",passWord);
        model.addAttribute("address",address);
        model.addAttribute("city",city);
        model.addAttribute("postalCode",postalCode);
        model.addAttribute("ssId",ssId);

        return "registration";
    }
}
