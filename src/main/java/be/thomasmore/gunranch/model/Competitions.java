package be.thomasmore.gunranch.model;

import jakarta.persistence.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Competitions {
    @Id
    private Integer id;

    private String name;

    @Temporal(TemporalType.TIME)
    private Date startingHour;

    @Temporal(TemporalType.TIME)
    private Date endingHour;

    @Temporal(TemporalType.DATE)
    private Date Date;

    private int participationPrice;

    private String info;

    //Nr of participants

    //guns allowed

    //rating
    private String image;


    public Competitions(String name, java.util.Date startingHour, java.util.Date endingHour, java.util.Date date, int participationPrice, String info, Participants numberOfParticipants, String image) {
        this.name = name;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        Date = date;
        this.participationPrice = participationPrice;
        this.info = info;
        this.numberOfParticipants = numberOfParticipants;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(java.util.Date startingHour) {
        this.startingHour = startingHour;
    }

    public java.util.Date getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(java.util.Date endingHour) {
        this.endingHour = endingHour;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getParticipationPrice() {
        return participationPrice;
    }

    public void setParticipationPrice(int participationPrice) {
        this.participationPrice = participationPrice;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Participants getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Participants numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
