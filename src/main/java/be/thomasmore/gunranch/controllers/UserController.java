package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Reservation;
import be.thomasmore.gunranch.repositorys.ReservationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public String reservations(Model model){
        Iterable<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("model",model);
        model.addAttribute("reservations",reservations);
        return "reservations";
    }

    @PostMapping("/reservations")
    public String submitReservation(@Valid Reservation reservation, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "reservations";
        }
        return "reservationdetails";
    }

    @GetMapping("/reservationdetails")
    public String reservationDetais(Model model){
        Iterable<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("reservations",reservations);
        return "/reservationdetails";
    }
}
