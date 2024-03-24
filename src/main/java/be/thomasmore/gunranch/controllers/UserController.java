package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Members;
import be.thomasmore.gunranch.repositorys.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model, Principal principal){
        if(principal != null) return "redirect:/guns";
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(Model model, Principal principal){
        if (principal == null) return "redirect:/guns";
        return "user/logout";
    }
    @GetMapping("/registration")
    public String registration(Model model, String firstName,
                               String lastName, String userName,
                               String gender,
                               String emailAddress,
                               String phoneNumber,
                               String passWord,
                               String address,
                               String city,
                               String ssId,
                               String postalCode){
        model.addAttribute("users", new Members());
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("userName",userName);
        model.addAttribute("gender",gender);
        model.addAttribute("emailAddress",emailAddress);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("passWord",passWord);
        model.addAttribute("address",address);
        model.addAttribute("city",city);
        model.addAttribute("postalCode",postalCode);
        model.addAttribute("ssId",ssId);

        return "user/registration";
    }
    @PostMapping("/registration")
    public String submitReservationForm(@Valid Members users, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "user/registration";
        }
        model.addAttribute("users",users);
        userRepository.save(users);
        return "redirect:user/profile";
    }

}
