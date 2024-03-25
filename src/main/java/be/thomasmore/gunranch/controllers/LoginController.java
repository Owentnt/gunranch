package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Users;
import be.thomasmore.gunranch.repositorys.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/login")
        public String login(Model model, Principal principal) {
            if (principal != null) return "redirect:/";
            return "/login";
    }
    @GetMapping("/logout")
    public String logout(Model model, Principal principal) {
        if (principal == null) return "redirect:/";
        return "/logout";
    }

    @GetMapping("/registration")
    public String registration(Model model, String firstName,
                               String lastName, String username,
                               String gender,
                               String emailAddress,
                               String phoneNumber,
                               String password,
                               String address,
                               String city,
                               String ssId,
                               String postalCode){
        model.addAttribute("users", new Users());
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("username",username);
        model.addAttribute("gender",gender);
        model.addAttribute("emailAddress",emailAddress);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("password",password);
        model.addAttribute("address",address);
        model.addAttribute("city",city);
        model.addAttribute("postalCode",postalCode);
        model.addAttribute("ssId",ssId);

        return "/registration";
    }
    @PostMapping("/registration")
    public String submitReservationForm(@Valid Users users, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "/registration";
        }
        model.addAttribute("users",users);
        userRepository.save(users);
        return "redirect:user/profile";
    }

//    @PostMapping("/registration")
//    public String registrationPost(Principal principal, HttpServletRequest request,
//                                   @RequestParam String firstName,
//                                   @RequestParam String lastName,
//                                   @RequestParam String username,
//                                   @RequestParam String gender,
//                                   @RequestParam String emailAddress,
//                                   @RequestParam String phoneNumber,
//                                   @RequestParam String password,
//                                   @RequestParam String address,
//                                   @RequestParam String city,
//                                   @RequestParam String ssId,
//                                   @RequestParam String postalCode) throws Exception {
//        if (principal != null) return "redirect:/";
//        if (username == null || username.isBlank()) return "redirect:/";
//        if (jdbcUserDetailsManager.userExists(username)) return "redirect:/";
//
//        UserDetails user = org.springframework.security.core.userdetails.User
//                .withUsername(username)
//                .password(passwordEncoder.encode(password))
//                .roles("USER")
//                .build();
//        jdbcUserDetailsManager.createUser(user);
//
//        Users newUser = new Users();
//        newUser.setFirstName(firstName);
//        newUser.setLastName(lastName);
//        newUser.setGender(gender);
//        newUser.setUsername(username);
//        newUser.setEmailAddress(emailAddress);
//        newUser.setPassword(password);
//        newUser.setPhoneNumber(phoneNumber);
//        newUser.setAddress(address);
//        newUser.setPostalCode(postalCode);
//        newUser.setCity(city);
//        newUser.setSsId(ssId);
//
//        //autologin:
//        request.login(username, password);
//        userRepository.save()
//        return "redirect:/";
//    }
//

}
