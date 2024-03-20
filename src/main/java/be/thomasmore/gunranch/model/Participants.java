package be.thomasmore.gunranch.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Participants {
    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String gender;

    private String emailAddress;

    private String phoneNumber;



    @ManyToMany(mappedBy = "participants")
    private Collection<Competitions> competitions;

    public Participants(int id, String firstName, String lastName, String gender, String emailAddress, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public Participants() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<Competitions> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Collection<Competitions> competitions) {
        this.competitions = competitions;
    }
}
