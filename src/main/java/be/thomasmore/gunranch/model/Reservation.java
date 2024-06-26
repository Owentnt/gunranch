package be.thomasmore.gunranch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    private Users users;

//    @NotNull(message = "Amount of participants is required")
//    @Min( value = 1, message = "Please enter a positive number")
//    @Max(value = 8, message = "Max 8 participants")
    private int amountOfParticipants;

//    @NotNull(message = "Date is required")
//    @Future(message = "Please select a date in the future")
//    @Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date date;

//    @FutureOrPresent(message = "Please select a time in the present or future")
//    @NotNull(message = "Time is required")
//    @Temporal(TemporalType.TIME)
@DateTimeFormat(pattern = "HH:mm")
private Date time;


    @ManyToMany()
    @JoinTable(name = "reservation_guns")
    private List<Guns> gunsPackage;



    public Reservation(int id,int amountOfParticipants, Date date, Date time) {
        this.id = id;
        this.amountOfParticipants = amountOfParticipants;
        this.date = date;
        this.time = time;

    }

    public Reservation() {

    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Guns> getGunsPackage() {
        return gunsPackage;
    }

    public void setGunsPackage(List<Guns> gunsPackage) {
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
