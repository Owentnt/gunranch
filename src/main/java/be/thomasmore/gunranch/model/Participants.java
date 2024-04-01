package be.thomasmore.gunranch.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Participants {
    @Id
    private int id;

    private String playerName;

    private Date birthDate;

    private String skillLevel;

    private String medicalConditions;

    @ManyToOne
    private Users users;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Competitions> competitions;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Guns> chosenGuns;

    public Participants(int id, String playerName, Date birthDate, String skillLevel, String medicalConditions) {
        this.id = id;
        this.playerName = playerName;
        this.birthDate = birthDate;
        this.skillLevel = skillLevel;
        this.medicalConditions = medicalConditions;
    }

    public Participants() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Collection<Guns> getChosenGuns() {
        return chosenGuns;
    }

    public void setChosenGuns(Collection<Guns> chosenGuns) {
        this.chosenGuns = chosenGuns;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Collection<Competitions> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Collection<Competitions> competitions) {
        this.competitions = competitions;
    }
}
