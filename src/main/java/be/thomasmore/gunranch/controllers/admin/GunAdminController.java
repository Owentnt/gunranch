package be.thomasmore.gunranch.controllers.admin;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositories.GunsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class GunAdminController {

    @Autowired
    private GunsRepository gunsRepository;

    private final Logger logger = LoggerFactory.getLogger(GunAdminController.class);

    @GetMapping({"/editguns/{id}", "/editguns"})
    public String editGuns(Model model, @PathVariable Integer id, Guns guns) {
        model.addAttribute("id", id);
        model.addAttribute("guns", guns);
        logger.info(String.format("gunEdit" + id));
        return "admin/editguns";
    }

    @ModelAttribute("guns")
    public Guns findGun(@PathVariable(required = false) Integer id) {
        logger.info("findGun " + id);
        if (id == null) return new Guns();
        Optional<Guns> gunFinder = gunsRepository.findById(id);

        if (gunFinder.isPresent())
            return gunFinder.get();
        return null;
    }

    @PostMapping("/editguns/{id}")
    public String editGunsPost(@PathVariable Integer id, Guns guns) {
        logger.info("gunEditPost" + id + "-- new name=" + guns.getName()
                + "-- new gunType=" + guns.getGunType()
                + "-- new Magazine=" + guns.getMagazine()
                + "-- new Caliber=" + guns.getCaliber()
                + "-- new price=" + guns.getPrice()
                + "-- new firearmsType=" + guns.getFirearmsType()
                + "-- new bio=" + guns.getBio()
                + "-- new image=" + guns.getImage());
        gunsRepository.save(guns);
        return "redirect:/gunsdetails/" + id;
    }

    @GetMapping("/newgun")
    public String newGun(Model model, Guns guns) {
        model.addAttribute("guns", guns);
        logger.info("gunNew");
        return "admin/newgun";
    }
    @PostMapping("/newgun")
    public String newGunPost(Guns guns) {
        logger.info("newGunPost -- new name=" + guns.getName() +
                ", type=" + guns.getGunType() +
                ", magazine=" + guns.getMagazine() +
                ", caliber=" + guns.getCaliber() +
                ", price=" + guns.getPrice() +
                ", fireArmsType=" + guns.getFirearmsType() +
                ", bio=" +guns.getBio() +
                ", image=" + guns.getImage());
        Guns newGun = gunsRepository.save(guns);
        return "redirect:/gunsdetails/" + newGun.getId();
    }
}
