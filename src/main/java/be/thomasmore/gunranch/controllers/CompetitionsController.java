package be.thomasmore.gunranch.controllers;

import be.thomasmore.gunranch.model.Competitions;
import be.thomasmore.gunranch.model.Guns;
import be.thomasmore.gunranch.model.Participants;
import be.thomasmore.gunranch.repositories.CompetitionRepository;
import be.thomasmore.gunranch.repositories.GunsRepository;
import be.thomasmore.gunranch.repositories.ParticipantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;



@Controller
public class CompetitionsController {

    private final Logger logger = LoggerFactory.getLogger(Competitions.class);
    @Autowired
    CompetitionRepository competitionRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    GunsRepository gunsRepository;

    @GetMapping("/competitions")
    public String competitions(Model model) {
        final Iterable<Competitions> allComps = competitionRepository.findAll();
        List<Competitions> playerCount = competitionRepository.countParticipantsPerCompetition();
        model.addAttribute("competitions", allComps);
        model.addAttribute("playerCount",playerCount);
        return "user/competitions";
    }

    @GetMapping("/competitions/filter")
    public String competitionsFilter(Model model, @RequestParam(required = false) Double minPrice,
                                     @RequestParam(required = false) Double maxPrice,
                                     @RequestParam(required = false) Date startDate,
                                     @RequestParam(required = false) Date endDate,
                                     @RequestParam(required = false) Date startHour,
                                     @RequestParam(required = false) Date endHour,
                                     @RequestParam(required = false) List <String> allowedGuns,
                                     @RequestParam(required = false) Integer nrOfPlayers,
                                     @RequestParam(required = false) String keyword) {


        Iterable<Competitions> allGames = competitionRepository.findAll();

        //allGames = competitionRepository.findByFilter(minPrice, maxPrice, startDate, endDate, startHour, endHour, nrOfPlayers, keyword,allowedGuns);
        logger.info(String.format("competitionsFilter -- keyword=%s", keyword));
        model.addAttribute("competitions", allGames);
        model.addAttribute("startingHour", startHour);
        model.addAttribute("endingHour", endHour);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("participationPriceMin", minPrice);
        model.addAttribute("participationPriceMax", maxPrice);
        model.addAttribute("keyword",keyword);
        model.addAttribute("allowedGuns",allowedGuns);
        model.addAttribute("nrOfPlayers",nrOfPlayers);
        model.addAttribute("filtersEnabled", true);
        return "user/competitions";
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
        Iterable <Competitions> chosenGame = competitionRepository.findAll();
        Iterable<Guns> selectedGuns = gunsRepository.findAll();
        model.addAttribute("chosenGame",chosenGame);
        model.addAttribute("selectedGuns",selectedGuns);

        return "participationform";
    }
    @PostMapping("/participationform")
    public String submitParticipationForm(Model model,Participants participants){
        model.addAttribute("participation",participants);
        participantRepository.save(participants);
        return "redirect:/participationdetails";
    }
    @GetMapping("/scoreboard")
    public String scores(Model model,Competitions competitions){
        model.addAttribute("competitions",competitions);
        return "scoreboard";
    }
}