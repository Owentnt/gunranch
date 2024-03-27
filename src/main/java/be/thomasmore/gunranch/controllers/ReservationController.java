package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.model.Reservation;
import be.thomasmore.gunranch.repositorys.GunsRepository;
import be.thomasmore.gunranch.repositorys.ReservationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@Validated
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    GunsRepository gunsRepository;

    @GetMapping("/reservations")
    public String reservationsForm(Reservation reservations,Model model, String selectedGun){
        Iterable <Guns> gunsPackage = gunsRepository.findAll();
        Iterable <Reservation> reservations1 = reservationRepository.findAll();
        model.addAttribute("reservations",reservations);
        model.addAttribute("gunsPackage",gunsPackage);
        model.addAttribute("selectedGun",selectedGun);
        String selectedGunsText = String.join(", ", selectedGun);
        model.addAttribute("selectedGuns",selectedGunsText);

        return "reservations";
    }

    @PostMapping("/reservations")
    public String submitReservationForm(@Valid Reservation reservations, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            return "reservations";
        }
        model.addAttribute("reservations",reservations);
        reservationRepository.save(reservations);
        return "redirect:/reservationdetails";
    }

    @GetMapping("/reservationdetails")
    public String reservationDetais(Model model){
        Iterable<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("reservations",reservations);
        return "reservationdetails";
    }
    @GetMapping("/userprofiledetails")
    public String profile(Model model,Reservation reservation){
        model.addAttribute("reservation",reservation);
        return "profile";
    }
}
