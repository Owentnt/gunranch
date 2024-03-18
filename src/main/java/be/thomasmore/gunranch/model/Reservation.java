package be.thomasmore.gunranch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="users_id", nullable=false)
    private Users users;

    @NotBlank(message = "Amount of participants is required")
    @Min( value = 1, message = "Please enter a positive number")
    @Max(value = 8, message = "Max 8 participants")
    private int amountOfParticipants;

    @DateTimeFormat(pattern = "DD/MM/YYYY")
    @NotBlank(message = "Date is required")
    @Future(message = "Please select a date in the future")
    @Temporal(TemporalType.DATE)
    private Date date;

    @FutureOrPresent(message = "Please select a time in the present or future")
    @NotBlank(message = "Time is required")
    @DateTimeFormat(pattern = "HH:MM")
    @Temporal(TemporalType.TIME)
    private Date time;




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
