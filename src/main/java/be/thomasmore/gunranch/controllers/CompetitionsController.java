package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Competitions;
import be.thomasmore.gunranch.model.Participants;
import be.thomasmore.gunranch.repositorys.CompetitionRepository;
import be.thomasmore.gunranch.repositorys.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Optional;

@Controller
public class CompetitionsController {

    @Autowired
    CompetitionRepository competitionRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @GetMapping("/competitions")
    public String competitions(Model model) {
        final Iterable<Competitions> allComps = competitionRepository.findAll();
        model.addAttribute("competitions", allComps);
        return "competitions";
    }

    @GetMapping("/competitions/filter")
    public String competitionsFilter(Model model, @RequestParam(required = false) String title,
                                     @RequestParam(required = false) Date startingHour,
                                     @RequestParam(required = false) Date endingHour,
                                     @RequestParam(required = false) Date date,
                                     @RequestParam(required = false) Date registrationDeadline,
                                     @RequestParam(required = false) double participationPrice,
                                     @RequestParam(required = false) String bio,
                                     @RequestParam(required = false) String image) {

        Iterable<Competitions> allComps = competitionRepository.findAll();
        model.addAttribute("competitions", allComps);
        model.addAttribute("title", title);
        model.addAttribute("startingHour", startingHour);
        model.addAttribute("endingHour", endingHour);
        model.addAttribute("date", date);
        model.addAttribute("registrationDeadline", registrationDeadline);
        model.addAttribute("participationPrice", participationPrice);
        model.addAttribute("bio", bio);
        model.addAttribute("image", image);
        model.addAttribute("filtersEnabled", true);
        return "competitions";
    }

    @GetMapping({"/competitionsdetails/{id}", "/competitionsdetails"})
    public String compDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "competitionsdetails";
        Optional<Competitions> compDatabase = competitionRepository.findById(id);
        compDatabase.ifPresent(competitions -> model.addAttribute("competitions", competitions));
        if (compDatabase.isPresent()) {
            Optional<Competitions> previousComp = competitionRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (previousComp.isEmpty())
                previousComp = competitionRepository.findFirstByOrderByIdDesc();
            Optional<Competitions> nextComp = competitionRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextComp.isEmpty())
                nextComp = competitionRepository.findFirstByOrderByIdAsc();
            model.addAttribute("previousComp", previousComp.get().getId());
            model.addAttribute("nextComp", nextComp.get().getId());

        }

        return "competitionsdetails";
    }

    @GetMapping("/participationform")
    public String participationForm(Model model) {
        model.addAttribute("participations", new Participants());
        return "participationform";
    }
}