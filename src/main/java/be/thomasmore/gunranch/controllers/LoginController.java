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
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        if (principal != null) return "redirect:/";
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(Model model, Principal principal) {
        if (principal == null) return "redirect:/";
        return "user/logout";
    }

    @GetMapping("/registration")
    public String registration(Users users, Model model) {
        model.addAttribute("user", users);
        return "/registration";
    }

    @PostMapping("/registration")
    public String submitReservationForm(
                                        Model model,
                                        @RequestParam("firstName") String firstName,
                                        @RequestParam("lastName") String lastName,
                                        @RequestParam("username") String username,
                                        @RequestParam("gender") String gender,
                                        @RequestParam("emailAddress") String emailAddress,
                                        @RequestParam("phoneNumber") String phoneNumber,
                                        @RequestParam("password") String password,
                                        @RequestParam("address") String address,
                                        @RequestParam("city") String city,
                                        @RequestParam("ssId") String ssId,
                                        @RequestParam("postalCode") String postalCode) {

//        if (bindingResult.hasErrors()) {
//            return "/registration";
//        }
      //  model.addAttribute("users", users);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("username", username);
        model.addAttribute("gender", gender);
        model.addAttribute("emailAddress", emailAddress);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("password", password);
        model.addAttribute("address", address);
        model.addAttribute("city", city);
        model.addAttribute("postalCode", postalCode);
        model.addAttribute("ssId", ssId);
       // userRepository.save(users);
        return "redirect:/profile";
    }

    @GetMapping("profile")
    public String profile(Model model, Users profile) {
        model.addAttribute("profile", profile);
        return "profile";
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
