package be.thomasmore.gunranch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    private int id;

    @ManyToOne
    private Members users;

    @NotNull(message = "Amount of participants is required")
    @Min( value = 1, message = "Please enter a positive number")
    @Max(value = 8, message = "Max 8 participants")
    private int amountOfParticipants;

    @NotNull(message = "Date is required")
    @Future(message = "Please select a date in the future")
    @Temporal(TemporalType.DATE)
    private Date date;

    @FutureOrPresent(message = "Please select a time in the present or future")
    @NotNull(message = "Time is required")
    @Temporal(TemporalType.TIME)
    private Date time;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "reservations")
    @Size(max = 5)
    private Collection<Guns> gunsPackage;



    public Reservation(int id,int amountOfParticipants, Date date, Date time) {
        this.id = id;
        this.amountOfParticipants = amountOfParticipants;
        this.date = date;
        this.time = time;

    }

    public Reservation() {

    }

    public Members getUsers() {
        return users;
    }

    public void setUsers(Members users) {
        this.users = users;
    }

    public Collection<Guns> getGunsPackage() {
        return gunsPackage;
    }

    public void setGunsPackage(Collection<Guns> gunsPackage) {
        this.gunsPackage = gunsPackage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getAmountOfParticipants() {
        return amountOfParticipants;
    }

    public void setAmountOfParticipants(int amountOfParticipants) {
        this.amountOfParticipants = amountOfParticipants;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
