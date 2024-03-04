package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositorys.GunsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GunsController {

    @Autowired
    GunsRepository gunsRepository;

    @GetMapping("/guns")
    public String guns(Model model){
        Iterable<Guns> guns = gunsRepository.findAll();
        model.addAttribute("guns",guns);
        return "guns";

    }



@GetMapping("/competitions")
    public String competitions(Model model){
        model.addAttribute("model",model);
        return "competitions";
}
}
