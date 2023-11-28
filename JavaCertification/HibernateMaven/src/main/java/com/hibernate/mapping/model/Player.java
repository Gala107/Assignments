package com.hibernate.mapping.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int playerId;
	@Column(nullable=false, name="name")
	private String playerName;
//	@ManyToOne
//	private Team team;
	@OneToMany
	List<Team> teams = new ArrayList<Team>();
	private int age;
	
	public Player() {
	}
	
	public Player(String playerName, List teams, int age) {
		this.playerName = playerName;
		this.teams = teams;
		this.age = age;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	/*
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	*/
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeam(List<Team> teams) {
		this.teams = teams;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", team=" + teams + ", age=" + age + "]";
	}
}
