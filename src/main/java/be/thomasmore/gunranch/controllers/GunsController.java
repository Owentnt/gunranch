package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositorys.gunsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GunsController {

    @Autowired
    gunsRepository gunsRepository;

    @GetMapping("/guns")
    public String guns(Model model){
        Guns guns = new Guns();
        model.addAttribute("guns",guns);
        model.addAttribute("name",guns.getName());
        return "guns";

    }



@GetMapping("/competitions")
    public String competitions(Model model){
        model.addAttribute("model",model);
        return "competitions";
}
}
