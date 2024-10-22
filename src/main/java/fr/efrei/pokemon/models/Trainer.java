package fr.efrei.pokemon.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	private String name;

	@OneToMany
	private List<Pokemon> team;

	@ElementCollection
	private List<String> badges;

	public String getId() {
		return id;
	}

	private boolean isChampion = false;
	@ManyToOne
	private Arene arene;

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getTeam() {
		return team;
	}
	public List<String> getBadges() { return badges; }
	public void setBadges(List<String> badges) { this.badges = badges; }
	public void setTeam(List<Pokemon> team) {
		this.team = team;
	}
}
