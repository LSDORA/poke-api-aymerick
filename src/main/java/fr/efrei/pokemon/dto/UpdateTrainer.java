package fr.efrei.pokemon.dto;

import jakarta.persistence.ElementCollection;

import java.util.List;

public class UpdateTrainer {

	private String name;

	private List<String> team;
	@ElementCollection
	private List<String> badges;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTeam() {
		return team;
	}

	public List<String> getBadges() { return badges; }

	public void setBadges(List<String> badges) { this.badges = badges; }


	public void setTeam(List<String> team) {
		this.team = team;
	}
}
