package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.Type;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID) // AUTO INCREMENT
	private String id;

	private String name;

	private int level;

	private Integer healthPoints = 100;

	//@ElementCollection
	@Enumerated(EnumType.STRING)
	//private List<Type> types; // Liste des types
	private Type type;

	@ManyToMany
	@JoinTable(
			name = "POKEMON_ATTACKS",
			joinColumns = @JoinColumn(name = "POKEMON_ID"),
			inverseJoinColumns = @JoinColumn(name = "ATTACK_ID")
	)
	private List<Attaque> attacks;

	public Pokemon() {
		this.healthPoints = 100;
	}

	public Attaque getRandomAttack(){
        return null;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Integer getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(Integer healthPoints) {
		this.healthPoints = healthPoints;
	}

	public /*List<Type>*/ Type getTypes() {
		//return types;
		return type;
	}

	public void setTypes(/*List<Type> types */ Type type) {
		//this.types = types;
		this.type = type;
	}

	public List<Attaque> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Attaque> attacks) {
		this.attacks = attacks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
