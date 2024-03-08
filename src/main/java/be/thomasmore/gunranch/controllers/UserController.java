package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Reservation;
import be.thomasmore.gunranch.repositorys.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public String reservations(Model model){
        Iterable<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("model",model);
        return "reservations";
    }
}
