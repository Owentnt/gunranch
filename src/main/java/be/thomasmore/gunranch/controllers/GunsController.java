package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositorys.GunsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class GunsController {

    @Autowired
    GunsRepository gunsRepository;

    @GetMapping("/guns")
    public String guns(Model model, @RequestParam (required = false) String type,
                       @RequestParam (required = false) Integer minMagazine,
                       @RequestParam (required = false) Integer maxMagazine,
                       @RequestParam (required = false) String caliber,
                       @RequestParam (required = false) int minPrice,
                       @RequestParam (required = false) int maxPrice,
                       @RequestParam (required = false) String firearmsType){
        Iterable<Guns> guns = gunsRepository.findAll();
        model.addAttribute("guns",guns);
        return "guns";

    }

    @GetMapping({"/gunsdetails/{id}","/gunsdetails"})
    public String gunsDetails(Model model, @PathVariable(required = false)Integer id){
        if(id == null) return "gunsdetails";
        Optional<Guns> gunsDatabase = gunsRepository.findById(id);
        gunsDatabase.ifPresent(guns -> model.addAttribute("guns", guns));
        if (gunsDatabase.isPresent()) {
            Optional<Guns> previousGun = gunsRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (previousGun.isEmpty())
                previousGun = gunsRepository.findFirstByOrderByIdDesc();
            Optional<Guns> nextGun = gunsRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextGun.isEmpty())
                nextGun = gunsRepository.findFirstByOrderByIdAsc();
            model.addAttribute("previousGun", previousGun.get().getId());
            model.addAttribute("nextGun",nextGun.get().getId());
        }

        return "gunsdetails";
    }



@GetMapping("/competitions")
    public String competitions(Model model){
        model.addAttribute("model",model);
        return "competitions";
}
}
