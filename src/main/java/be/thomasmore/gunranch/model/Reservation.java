package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
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

    private boolean member;

    private String Address;

    private String city;

    public Reservation(int id, String firstName, String lastName,
                       String emailAdres, String phoneNumber,
                       int amountOfParticipants, Date date, boolean member,
                       String address, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdres = emailAdres;
        this.phoneNumber = phoneNumber;
        this.amountOfParticipants = amountOfParticipants;
        this.date = date;
        this.member = member;
        Address = address;
        this.city = city;
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

    public String getEmailAdres() {
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
