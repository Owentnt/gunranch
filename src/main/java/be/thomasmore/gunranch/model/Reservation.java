package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String emailAdres;

    private String phoneNumber;

    private int amountOfParticipants;

    private Date date;


}
