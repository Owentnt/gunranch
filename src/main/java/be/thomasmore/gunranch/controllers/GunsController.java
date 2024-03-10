package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositorys.GunsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class GunsController {

    private Logger logger = LoggerFactory.getLogger(GunsController.class);

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
        logger.info(String.format("guns -- type=%d", type));
        logger.info(String.format("guns -- minmagazine=%d", minMagazine));
        logger.info(String.format("guns -- maxmagazine=%d", maxMagazine));
        logger.info(String.format("guns -- caliber=%d", caliber));
        logger.info(String.format("guns -- minprice=%d", minPrice));
        logger.info(String.format("guns -- maxprice=%d", maxPrice));
        logger.info(String.format("guns -- firearmstype=%d", firearmsType));
        Iterable<Guns> allGuns = gunsRepository.findAll();
        allGuns = gunsRepository.findByFilter(type,minMagazine,maxMagazine,caliber,minPrice,maxPrice,firearmsType);
        model.addAttribute("allGuns",allGuns);
        model.addAttribute("type",type);
        model.addAttribute("minMagazine",minMagazine);
        model.addAttribute("maxMagazine",maxMagazine);
        model.addAttribute("caliber",caliber);
        model.addAttribute("minPrice",minPrice);
        model.addAttribute("maxPrice",maxPrice);
        model.addAttribute("firearmsType",firearmsType);
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
