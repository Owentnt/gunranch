package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    private int id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    @Pattern(regexp = "\\d{10}", message = "Phone number not valid")
    private String phoneNumber;

    private int amountOfParticipants;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;
    private boolean member;

    private String Address;

    private String city;

    public Reservation(int id, String firstName, String lastName,
                       String emailAdres, String phoneNumber,
                       int amountOfParticipants, Date date, Date time, boolean member,
                       String address, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAdres;
        this.phoneNumber = phoneNumber;
        this.amountOfParticipants = amountOfParticipants;
        this.date = date;
        this.time = time;
        this.member = member;
        this.Address = address;
        this.city = city;
    }

    public Reservation() {

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
