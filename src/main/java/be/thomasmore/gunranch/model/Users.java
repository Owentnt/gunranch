package be.thomasmore.gunranch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Set;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    private int id;

    @OneToMany(mappedBy="users")
    private Set<Reservation> reservations;

    @OneToMany(mappedBy = "users")
    private Set<Participants> participants;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private boolean enabled;
    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    private String gender;

    @Column(unique=true)
    private String username;

    @NotNull(message = "Email address is required")
    @Email(message = "Please enter a valid email")
    private String emailAddress;

    @Pattern(regexp = "\\d{10}", message = "Phone number not valid")
    @NotNull(message = "Phone number is required")
    private String phoneNumber;

    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "Postal code is required")
    @Pattern(regexp = "\\d{4}", message = "Postal code not valid")
    private String postalCode;
    @NotNull(message = "City is required")
    private String city;

    @NotNull(message = "Password is required")
//@Size(min = 10, max = 20)
    @Column(length = 100)
/*@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[&@#§è!+=?^])(?=\\S+$)",
        message = "passWord does not meet requirements, " +
                "It has to contain at least one digit, one lowercase letter, " +
                "one uppercase letter, no whitespace and a special character")*/
    private String password;

    @Pattern(regexp ="\\d{6}-\\d{3}.\\d{2}", message = "ssId is not valid")
    private String ssId;


    public Users(int id, String firstName, String lastName, String username, String gender, String emailAddress,
                 String phoneNumber, String address, String postalCode, String city,
                 String password, String ssId, boolean enabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.password = password;
        this.ssId = ssId;
        this.enabled = enabled;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Participants> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participants> participants) {
        this.participants = participants;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Users() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setEmailAddress(String emailAdres) {
        this.emailAddress = emailAdres;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
