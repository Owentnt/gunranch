package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import java.util.Set;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    private int id;

    @OneToMany(mappedBy="users")
    private Set<Reservation> reservations;

    @NotNull(message = "First name is required")
    private String firstName;


    @NotNull(message = "Last name is required")
    private String lastName;

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
    @Size(min = 10, max = 20)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[&@#§è!+=?^])(?=\\S+$)",
            message = "passWord does not meet requirements, " +
                    "It has to contain at least one digit, one lowercase letter, " +
                    "one uppercase letter, no whitespace and a special character")
    private String passWord;

    @Pattern(regexp ="\\d{6}-\\d{3}.\\d{2}", message = "ssId is not valid")
    private String ssId;


    public Users(int id, String firstName, String lastName, String emailAddress,
                 String phoneNumber, String address, String postalCode, String city,
                 String passWord, String ssId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.passWord = passWord;
        this.ssId = ssId;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
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


    public Users() {
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
