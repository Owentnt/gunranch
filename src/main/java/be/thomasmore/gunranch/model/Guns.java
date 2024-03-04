package be.thomasmore.gunranch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.Length;



@Entity
public class Guns {
    @Id
    private int id;

    private String name;

    private String type;

    private int magazine;

    private String caliber;

    @Length(max = 1000)
    private String bio;

    private double price;

    private String image;
    public Guns(int id, String name, String type, int magazine, String caliber, String bio, double price, String image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.magazine = magazine;
        this.caliber = caliber;
        this.bio = bio;
        this.price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
