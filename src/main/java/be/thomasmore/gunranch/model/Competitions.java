package be.thomasmore.gunranch.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
public class Competitions {
    @Id
    private int id;

    private String title;

    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date startingHour;

    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date endingHour;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;


    private Double participationPrice;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "competitions")
    private Collection<Guns> allowedFirearms;

    @Length(max = 5000)
    private String objective;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "competitions")
    private Collection<Participants> participants;


    @Length(max = 1000)
    private String bio;


    public Competitions(int id, String title, Date startingHour, Date endingHour,
                        Date date, Double participationPrice,
                        String objective, String bio) {
        this.id = id;
        this.title = title;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.date = date;
        this.participationPrice = participationPrice;
        this.objective = objective;
        this.bio = bio;
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

    public Double getParticipationPrice() {
        return participationPrice;
    }

    public void setParticipationPrice(Double participationPrice) {
        this.participationPrice = participationPrice;
    }


    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getPlayerCount(int playerCount){
        return playerCount;
    }
    public void setPlayerCount(int playerCount) {
    }
}
