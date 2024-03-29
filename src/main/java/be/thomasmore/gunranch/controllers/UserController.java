package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Users;
import be.thomasmore.gunranch.repositorys.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

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
        logger.info("registrate");
        return "/registration";
    }
    @ModelAttribute("users")
    public Users findUser(String username) {
        logger.info("findUser " + username);
        if (username == null) return new Users();
        Optional<Users> findUser = userRepository.findByUsername(username);

        if (findUser.isPresent())
            return findUser.get();
        return null;
    }


    @PostMapping("/registration")
    public String submitRegistrationForm(
                                        Model model, Users users,
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
                                        @RequestParam("postalCode") String postalCode,
                                        @RequestParam("image") String image,
                                        @RequestParam("aboutMe") String aboutMe) {


        logger.info("registration" + username + "-- new username=" + users.getUsername()
                + "-- new firstName=" + users.getFirstName()
                + "-- new lastName=" + users.getLastName()
                + "-- new gender=" + users.getGender()
                + "-- new emailAddress=" + users.getEmailAddress()
                + "-- new phoneNumber=" + users.getPhoneNumber()
                + "-- new address=" + users.getAddress()
                + "-- new postalCode=" + users.getPostalCode()
                + "-- new city=" + users.getCity()
                + "-- new ssId=" + users.getSsId()
                + "-- new image=" + users.getImage()
                + "-- new aboutMe=" + users.getAboutMe());
        model.addAttribute("users", users);
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
        model.addAttribute("image",image);
        model.addAttribute("aboutMe",aboutMe);
        userRepository.save(users);
        return "redirect:/profile";
    }

    @GetMapping("profile")
    public String profile(Model model, Principal principal) {
        if (principal != null){
            final String loginName = principal.getName();
            System.out.println(principal.getName());
            Optional<Users> user = userRepository.findByUsername(loginName);
            model.addAttribute("user", user.get());

        }else{
            return "/registration";
        }

   //     model.addAttribute("user", user);
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
