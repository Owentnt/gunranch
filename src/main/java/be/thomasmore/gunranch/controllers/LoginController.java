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

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model,String userName, String passWord){
        model.addAttribute("userName",userName);
        model.addAttribute("passWord",passWord);
        return "login";
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

        return "registration";
    }
    @PostMapping("/registration")
    public String submitReservationForm(@Valid Members users, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "registration";
        }
        model.addAttribute("users",users);
        userRepository.save(users);
        return "redirect:/profile";
    }

}
