package be.thomasmore.gunranch.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.Collection;


@Entity
public class Guns {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    private String gunType;

    private int magazine;

    private String caliber;

    @Length(max = 1000)
    private String bio;

    private Double price;

    private String image;

    private String firearmsType;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "gunsPackage")
    private Collection<Reservation> reservations;


    public Guns(int id, String name, String type, int magazine, String caliber,
                String bio, Double price, String firearmsType, String image) {
        this.id = id;
        this.name = name;
        this.gunType = type;
        this.magazine = magazine;
        this.caliber = caliber;
        this.bio = bio;
        this.price = price;
        this.image = image;
        this.firearmsType = firearmsType;
    }



    public Guns() {
    }


    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGunType() {
        return gunType;
    }

    public void setGunType(String type) {
        this.gunType = type;
    }

    public int getMagazine() {
        return magazine;
    }

    public void setMagazine(int magazine) {
        this.magazine = magazine;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double prijs) {
        this.price = prijs;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFirearmsType() {
        return firearmsType;
    }

    public void setFirearmsType(String firearmType) {
        this.firearmsType = firearmType;
    }



}
