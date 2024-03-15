package be.thomasmore.gunranch.controllers.admin;

import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositorys.GunsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class GunAdminController {

    @Autowired
    private GunsRepository gunsRepository;

    private final Logger logger = LoggerFactory.getLogger(GunAdminController.class);

    @GetMapping({"/editguns/{id}","/editguns"})
    public String editGuns(Model model, @PathVariable Integer id, Guns guns) {
        model.addAttribute("id",id);
        model.addAttribute("guns",guns);
        logger.info(String.format("gunEdit" + id ));
        return "admin/editguns";
    }

}