package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.Type;
import jakarta.persistence.*;

@Entity
public class Arene {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    @OneToOne(mappedBy = "arene")
    private Trainer champion;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String badge;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getChampion() {
        return champion;
    }

    public void setChampion(Trainer champion) {
        this.champion = champion;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }
}
