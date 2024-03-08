package be.thomasmore.gunranch.model;

import jakarta.persistence.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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

    private double participationPrice;

    @ManyToOne
    private Guns guns;

    private String objective;

    private int rating;

    @ManyToOne
    private Participants nrOfParticipants;

    private String image;

    private String rules;

    private String timeLimit;

    private String rounds;

    private String safety;

    public Competitions(int id, String title, Date startingHour, Date endingHour,
                        Date date, double participationPrice, Guns guns,
                        String objective, int rating, Participants nrOfParticipants,
                        String image, String rules, String timeLimit,
                        String rounds, String safety) {
        this.id = id;
        this.title = title;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.date = date;
        this.participationPrice = participationPrice;
        this.guns = guns;
        this.objective = objective;
        this.rating = rating;
        this.nrOfParticipants = nrOfParticipants;
        this.image = image;
        this.rules = rules;
        this.timeLimit = timeLimit;
        this.rounds = rounds;
        this.safety = safety;
    }

    public Competitions() {
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

    public Guns getGuns() {
        return guns;
    }

    public void setGuns(Guns guns) {
        this.guns = guns;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Participants getNrOfParticipants() {
        return nrOfParticipants;
    }

    public void setNrOfParticipants(Participants nrOfParticipants) {
        this.nrOfParticipants = nrOfParticipants;
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

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }
}
