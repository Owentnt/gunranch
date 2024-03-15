package be.thomasmore.gunranch.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;


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

    private Integer participationPrice;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "competitions")
    private Collection<Guns> allowedFirearms;

    @Length(max = 5000)
    private String objective;


    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Participants> participants;

    private String image;

    @Length(max = 1000)
    private String bio;


    public Competitions(int id, String title, Date startingHour, Date endingHour,
                        Date date,Date registrationDeadline, Integer participationPrice,
                        String objective, String image,String bio) {
        this.id = id;
        this.title = title;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.date = date;
        this.registrationDeadline = registrationDeadline;
        this.participationPrice = participationPrice;
        this.objective = objective;
        this.image = image;
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

    public double getParticipationPrice() {
        return participationPrice;
    }

    public void setParticipationPrice(Integer participationPrice) {
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }
}
