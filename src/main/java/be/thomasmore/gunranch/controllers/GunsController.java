package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositorys.GunsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

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

    @GetMapping({"/gunsdetails/{id}","/gunsdetails"})
    public String gunsDetails(Model model, @PathVariable(required = false)Integer id){
        if(id == null) return "gunsdetails";
        Optional<Guns> gunsDatabase = gunsRepository.findById(id);
        gunsDatabase.ifPresent(guns -> model.addAttribute("guns", guns));
        return "gunsdetails";
    }



@GetMapping("/competitions")
    public String competitions(Model model){
        model.addAttribute("model",model);
        return "competitions";
}
}
