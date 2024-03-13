package be.thomasmore.gunranch.model;

import jakarta.persistence.*;


import java.util.Collection;
import java.util.Date;


@Entity
public class Competitions {
    @Id
    private int id;

    private String title;

    @Temporal(TemporalType.TIME)
    private Date startingHour;

    @Temporal(TemporalType.TIME)
    private Date endingHour;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.DATE)
    private Date registrationDeadline;

    private double participationPrice;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "competitions")
    private Collection<Guns> allowedFirearms;

    private String objective;


    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Participants> participants;

    private String image;

    private String rules;

    private int timeLimit;

    private int rounds;

    private String safety;

    public Competitions(int id, String title, Date startingHour, Date endingHour,
                        Date date,Date registrationDeadline, double participationPrice, Guns guns,
                        String objective, String image, String rules, int timeLimit,
                        int rounds, String safety) {
        this.id = id;
        this.title = title;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.date = date;
        this.registrationDeadline = registrationDeadline;
        this.participationPrice = participationPrice;
        this.objective = objective;
        this.image = image;
        this.rules = rules;
        this.timeLimit = timeLimit;
        this.rounds = rounds;
        this.safety = safety;
    }

    public Competitions() {
    }

    public Collection<Guns> getAllowedFirearms() {
        return allowedFirearms;
    }

    public void setAllowedFirearms(Collection<Guns> allowedFirearms) {
        this.allowedFirearms = allowedFirearms;
    }

    public Collection<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(Collection<Participants> nrOfParticipants) {
        this.participants = nrOfParticipants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(Date startingHour) {
        this.startingHour = startingHour;
    }

    public Date getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(Date endingHour) {
        this.endingHour = endingHour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getParticipationPrice() {
        return participationPrice;
    }

    public void setParticipationPrice(double participationPrice) {
        this.participationPrice = participationPrice;
    }


    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }
}
