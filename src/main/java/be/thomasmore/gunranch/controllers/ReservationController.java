package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.model.Reservation;
import be.thomasmore.gunranch.model.Users;
import be.thomasmore.gunranch.repositories.GunsRepository;
import be.thomasmore.gunranch.repositories.ReservationRepository;
import be.thomasmore.gunranch.repositories.UserRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Validated
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    GunsRepository gunsRepository;

    @Autowired
    UserRepository userRepository;


    private Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @GetMapping("/reservation")
    public String newReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("gunsList", getGunsList());
        return "editReservation";
    }

    @GetMapping({"/reservation/{id}"})
    public String editReservation(@PathVariable Integer id,
                                  Model model,
                                  Principal principal) {
        Optional<Reservation> reservation = reservationRepository.findById(Long.valueOf(id));
        if (reservation.isEmpty())
            return "redirect:/reservations";

        // check if user valid
        Users user = getCurrentUser(principal);
        if (user == null)
            return "redirect:/login";
        if (!user.equals(reservation.get().getUsers()))
            return "redirect:/reservations";

        model.addAttribute("reservation", reservation.get());
        model.addAttribute("gunsList", getGunsList());
        return "editReservation";
    }

    private List<Guns> getGunsList(){
        Iterable<Guns> gunsListIterator = gunsRepository.findAll();
        List<Guns> gunsList = new ArrayList<Guns>();
        for (Guns gun : gunsListIterator) {
            gunsList.add(gun);
        }
        return gunsList;
    }

    @PostMapping("/postreservation")
    public String postReservation(@ModelAttribute Reservation reservation,
                                  BindingResult bindingResult,
                                  Model model,
                                  Principal principal) {
        logger.info("POST request received for /reservations");
        if (bindingResult.hasErrors()) {
            logger.warn("Form submission has errors: {}", bindingResult.getAllErrors());

            return "reservation";
        }

        if (reservation.getUsers() == null){
            // set current user
            reservation.setUsers(getCurrentUser(principal));
        }

        logger.info("Saving reservation: {}", reservation.toString());
        reservationRepository.save(reservation);
        return "redirect:/reservations";
    }


    @GetMapping("/reservations")
    public String reservations(Model model, Principal principal) {
        if (principal != null){
            Users user = getCurrentUser(principal);
            Iterable<Reservation> reservations = reservationRepository.findByUsers(user);
            model.addAttribute("reservations", reservations);
            return "reservations";
        }else{
            return "redirect:/login";
        }

    }

    private Users getCurrentUser(Principal principal){
        Optional<Users> user = userRepository.findByUsername(principal.getName());
        if (user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

}
