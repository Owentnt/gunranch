package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Users;
import be.thomasmore.gunranch.repositories.AuthorityRepository;
import be.thomasmore.gunranch.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @GetMapping({"/registration/{username}"})
    public String editRegistration(@PathVariable(required = false) String username,
                                   Model model, Principal principal) {
        Optional<Users> registration = userRepository.findByUsername(username);
        Users user = getCurrentUser(principal);
        if (user == null) {
            return "redirect:/login";
        }
        if (!user.equals(registration.get())){
            return "redirect:/registration";
        }
        model.addAttribute("user", user);
        logger.info("registration: " + String.format(username));
        return "/registration";
    }

    @GetMapping({"/registration"})
    public String newRegistration(Model model) {
        Users users = new Users();
        model.addAttribute("user", users);
        //logger.info("registration: " + String.format(username));
        return "/registration";
    }

    @PostMapping("/postRegistration")
    public String postRegistration(@ModelAttribute() Users users,
                                   Model model,
                                   Principal principal) {
        logger.info("registration"  + "-- new username=" + users.getUsername()
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
        boolean insertFlag = false;
        if (users.getId() == 0) {
            // new user
            users.setEnabled(true);
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            insertFlag = true;

        }
        else{
            //edit user
            Users userPrincipal = getCurrentUser(principal);
            // restore username/paswoord
            users.setPassword(userPrincipal.getPassword());
            users.setUsername(userPrincipal.getUsername());
            users.setEnabled(userPrincipal.isEnabled());
        }

        userRepository.save(users);
        if (insertFlag) {
            authorityRepository.insertRecord(users.getUsername(), "USER");
        }

        return "redirect:/profile";
    }

    @GetMapping("profile")
    public String profile(Model model, Principal principal) {
        Users user = getCurrentUser(principal);
        if (user != null) {
            //final String loginName = principal.getName();
            System.out.println(principal.getName());
           // Optional<Users> user = userRepository.findByUsername(loginName);
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user",null);
        }
        return "profile";


    }


    private Users getCurrentUser(Principal principal) {
        if (principal != null){
            Optional<Users> user = userRepository.findByUsername(principal.getName());
            if (user.isPresent()) {
                return user.get();
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
}
