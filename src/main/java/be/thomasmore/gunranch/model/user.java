package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class user {
    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String emailAdres;

    private String phoneNumber;




}
