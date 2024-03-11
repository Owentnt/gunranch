package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.Length;



@Entity
public class Guns {
    @Id
    private int id;

    private String name;

    private String gunType;

    private int magazine;

    private String caliber;

    @Length(max = 1000)
    private String bio;

    private double price;

    private String firearmType;
    private String image;
    public Guns(int id, String name, String type, int magazine, String caliber, String bio, double price, String firearmType, String image) {
        this.id = id;
        this.name = name;
        this.gunType = type;
        this.magazine = magazine;
        this.caliber = caliber;
        this.bio = bio;
        this.price = price;
        this.firearmType = firearmType;
        this.image = image;
    }



    public Guns() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double prijs) {
        this.price = prijs;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFirearmType() {
        return firearmType;
    }

    public void setFirearmType(String firearmType) {
        this.firearmType = firearmType;
    }
}
