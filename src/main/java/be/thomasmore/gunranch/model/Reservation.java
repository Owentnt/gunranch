package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    private int id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email address is required")
    @Email(message = "Please enter a valid email")
    private String emailAddress;

    @Pattern(regexp = "\\d{10}", message = "Phone number not valid")
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

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


    private boolean member;


    @NotBlank(message = "Address is required")
    private String Address;

    @NotBlank(message = "City is required")
    private String city;


    public Reservation(int id, String firstName, String lastName,
                       String emailAddress, String phoneNumber,
                       int amountOfParticipants, Date date, Date time, boolean member,
                       String address, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
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
