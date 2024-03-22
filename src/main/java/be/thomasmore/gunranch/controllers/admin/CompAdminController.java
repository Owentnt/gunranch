package be.thomasmore.gunranch.controllers.admin;

import be.thomasmore.gunranch.model.Competitions;
import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.repositorys.CompetitionRepository;
import be.thomasmore.gunranch.repositorys.GunsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class CompAdminController {

    @Autowired
    private CompetitionRepository competitionRepository;

    private final Logger logger = LoggerFactory.getLogger(CompAdminController.class);

    @GetMapping({"/editcompetitions/{id}", "/editcompetitions"})
    public String editCompetitions(Model model, @PathVariable Integer id, Competitions competitions) {
        model.addAttribute("id", id);
        model.addAttribute("competitions", competitions);
        logger.info(String.format("compEdit" + id));
        return "admin/editcompetitions";
    }

    @ModelAttribute("competitions")
    public Competitions findComp(@PathVariable(required = false) Integer id) {
        logger.info("findComp " + id);
        if (id == null) return new Competitions();
        Optional<Competitions> compFinder = competitionRepository.findById(id);

        if (compFinder.isPresent())
            return compFinder.get();
        return null;
    }

    @PostMapping("/editcompetitions/{id}")
    public String editCompPost(@PathVariable Integer id, Competitions competitions) {
        logger.info("compEditPost" + id + "-- new title=" + competitions.getTitle()
                + "-- new Image=" + competitions.getImage()
                + "-- new Time=" + competitions.getDate().getTime()
                + "-- new Date=" + competitions.getDate()
                + "-- new registrationDate=" + competitions.getRegistrationDeadline()
                + "-- new Price=" + competitions.getParticipationPrice()
                + "-- new numberOfParticipants=" + competitions.getParticipants()
                + "-- new allowedFirearms=" + competitions.getAllowedFirearms()
                + "-- new bio" + competitions.getBio()
                + "-- new objective" + competitions.getObjective());

        competitionRepository.save(competitions);
        return "redirect:/competitionsdetails/" + id;
    }

}
