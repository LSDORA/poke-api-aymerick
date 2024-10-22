package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Attaque {

        @Id
        private String name;
        private Type type;
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


}
