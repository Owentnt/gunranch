package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.model.Reservation;
import be.thomasmore.gunranch.repositories.GunsRepository;
import be.thomasmore.gunranch.repositories.ReservationRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Validated
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    GunsRepository gunsRepository;

    private Logger logger = LoggerFactory.getLogger(ReservationController.class);

        @GetMapping("/reservations")
        public String reservationsForm(Model model) {
            logger.info("GET request received for /reservations");
            Iterable<Guns> gunsPackage = gunsRepository.findAll();
            model.addAttribute("reservation", new Reservation());
            model.addAttribute("gunsPackage", gunsPackage);
            return "reservations";
        }

        @PostMapping("/reservations")
        public String submitReservationForm(@Valid Reservation reservation, BindingResult bindingResult, Model model) {
            logger.info("POST request received for /reservations");
            if (bindingResult.hasErrors()) {
                logger.warn("Form submission has errors: {}", bindingResult.getAllErrors());
                Iterable<Guns> gunsPackage = gunsRepository.findAll();
                model.addAttribute("gunsPackage", gunsPackage);
                return "reservations";
            }

            logger.info("Saving reservation: {}", reservation);
            reservationRepository.save(reservation);
            return "redirect:/reservationdetails";
        }
    

    @GetMapping("/reservationdetails")
    public String reservationDetails(Model model) {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("reservations", reservations);
        return "reservationdetails";
    }



    @GetMapping("/userprofiledetails")
    public String profile(Model model,Reservation reservation){
        model.addAttribute("reservation",reservation);
        return "profile";
    }
}
