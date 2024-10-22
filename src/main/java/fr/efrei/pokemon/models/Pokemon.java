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

	private int healthPoints; // Points de vie

	@ElementCollection // Pour stocker une liste d'énumérations (types)
	@Enumerated(EnumType.STRING)
	private List<Type> types; // Liste des types

	@ElementCollection // Pour stocker les attaques
	private List<String> attacks; // Liste des attaques

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

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public List<String> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<String> attacks) {
		this.attacks = attacks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
