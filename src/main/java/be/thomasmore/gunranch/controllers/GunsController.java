package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Competitions;
import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositorys.CompetitionRepository;
import be.thomasmore.gunranch.repositorys.GunsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Controller
public class GunsController {


    @Autowired
    GunsRepository gunsRepository;

    @GetMapping("/guns")
    public String guns(Model model) {
        final Iterable<Guns> allGuns = gunsRepository.findAll();
        model.addAttribute("guns", allGuns);
        return "guns";
    }

    @GetMapping("/guns/filter")
    public String guns(Model model, @RequestParam(required = false) String gunType,
                       @RequestParam(required = false) Integer minMagazine,
                       @RequestParam(required = false) Integer maxMagazine,
                       @RequestParam(required = false) Integer minPrice,
                       @RequestParam(required = false) Integer maxPrice,
                       @RequestParam(required = false) String caliber,
                       @RequestParam(required = false) String firearmsType) {

        Iterable<Guns> allGuns = gunsRepository.findAll();
        allGuns = gunsRepository.findByFilter(minMagazine, maxMagazine, minPrice, maxPrice, caliber, gunType, firearmsType);
        model.addAttribute("guns", allGuns);
        model.addAttribute("gunType", "Handgun");
        model.addAttribute("minMagazine", minMagazine);
        model.addAttribute("maxMagazine", maxMagazine);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("caliber", caliber);
        model.addAttribute("gunType", gunType);
        model.addAttribute("firearmsType", firearmsType);
        model.addAttribute("filtersEnabled", true);
        return "guns";
    }


    @GetMapping({"/gunsdetails/{id}", "/gunsdetails"})
    public String gunsDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "gunsdetails";
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
            model.addAttribute("nextGun", nextGun.get().getId());
        }

        return "gunsdetails";
    }

    }



