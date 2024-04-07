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

        @GetMapping("/reservations")
        public String reservationsForm(Model model) {
            logger.info("GET request received for /reservations");
            Iterable<Guns> gunsPackage = gunsRepository.findAll();
            Iterable<Users> users = userRepository.findAll();
            model.addAttribute("reservation", new Reservation());
            model.addAttribute("gunsPackage", gunsPackage);
            model.addAttribute("users",users);
            return "reservations";
        }
    @GetMapping({"/reservations/{id}"})
    public String editReservation( Reservation reservation, @PathVariable Integer id, Model model) {

        model.addAttribute("id", id);
        model.addAttribute("reservations", reservation);
        logger.info(String.format("editReservation" + id));
        return "reservations";
    }
    @ModelAttribute("reservation")
    public Reservation findReservation(@PathVariable(required = false) Long id) {
        logger.info("findReservation " + id);
        if (id == null) return new Reservation();
        Optional<Reservation> bookingFinder = reservationRepository.findById(id);

        if (bookingFinder.isPresent())
            return bookingFinder.get();
        return null;
    }
    @PostMapping("/reservations/{id}")
    public String editReservationPost(@PathVariable Integer id, Reservation reservation) {
        logger.info("editReservation" + id + "-- new amount of participants=" + reservation.getAmountOfParticipants()
                + "-- new date=" + reservation.getDate()
                + "-- new time" + reservation.getTime()
                + "-- new gunPackage" + reservation.getGunsPackage());
        reservationRepository.save(reservation);
        return "redirect:/reservationdetails/" + id;
    }

        @PostMapping("/reservations")
        public String submitReservationForm(@Valid Reservation reservation, BindingResult bindingResult, Model model) {
            logger.info("POST request received for /reservations");
            if (bindingResult.hasErrors()) {
                logger.warn("Form submission has errors: {}", bindingResult.getAllErrors());
                Iterable<Guns> gunsPackage = gunsRepository.findAll();
                Iterable<Users> users = userRepository.findAll(); // Fetch users again
                model.addAttribute("gunsPackage", gunsPackage);
                model.addAttribute("users",users);
                return "reservations";
            }

            logger.info("Saving reservation: {}", reservation);
            reservationRepository.save(reservation);
            return "redirect:/reservationdetails";
        }


    @GetMapping("/reservationdetails")
    public String reservationDetails(Model model) {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        Iterable<Guns> gunsPackage = gunsRepository.findAll();
        model.addAttribute("reservations", reservations);
        model.addAttribute("gunPackage",gunsPackage);
        return "reservationdetails";
    }




}
