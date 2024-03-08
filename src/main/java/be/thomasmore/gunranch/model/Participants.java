package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Participants {
    @Id
    private int id;

    private String firstName;

    private String lastName;

    @ManyToOne
    private Competitions competition;




}
