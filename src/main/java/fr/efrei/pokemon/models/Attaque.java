package fr.efrei.pokemon.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.efrei.pokemon.constants.Type;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Attaque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private String name;

        @Enumerated(EnumType.STRING)
        private Type type;

        @ManyToMany(mappedBy = "attacks")
        @JsonIgnore
        private List<Pokemon> pokemons;


    private int power;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
