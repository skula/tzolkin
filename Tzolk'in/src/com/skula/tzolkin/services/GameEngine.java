package com.skula.tzolkin.services;

import java.util.ArrayList;
import java.util.List;

import com.skula.tzolkin.models.Building;
import com.skula.tzolkin.models.Gearing;
import com.skula.tzolkin.models.Pawn;
import com.skula.tzolkin.models.Player;
import com.skula.tzolkin.models.Religion;
import com.skula.tzolkin.models.Science;

public class GameEngine {
	public static final int PHASE_BLUE = 0;

	// Joueurs
	private List<Player> players;
	private int nPlayers;
	// Gameplay
	private Gearing gearing;
	private List<Building> monuments;
	private List<Building> buildingsLevel1;
	private List<Building> buildingsLevel2;

	public GameEngine(int nPlayer) {
		this.nPlayers = nPlayer;
		this.players = new ArrayList<Player>();
		for (int i = 0; i < nPlayer; i++) {
			players.add(new Player(i));
		}

		this.gearing = new Gearing();

		this.monuments = new ArrayList<Building>();
		for (int i = 0; i < 6; i++) {
			this.monuments.add(Building.MONUMENTS.remove(0));
		}

		this.buildingsLevel1 = new ArrayList<Building>();
		for (int i = 0; i < 6; i++) {
			this.buildingsLevel1.add(Building.BUILDINGS_LEVEL1.remove(0));
		}
		this.buildingsLevel2 = new ArrayList<Building>();

		// bouchon
		players.get(0).addPawns(new Pawn(0, 5));
		players.get(0).addPawns(new Pawn(0, 5));
		players.get(0).updateTemple(Religion.TEMPLE_RED, 1);
		players.get(0).updateTemple(Religion.TEMPLE_GREEN, 3);
		players.get(0).updateTemple(Religion.TEMPLE_YELLOW, 5);
		players.get(0).updateTech(Science.TECH_1, 0);
		players.get(0).updateTech(Science.TECH_2, 1);
		players.get(0).updateTech(Science.TECH_3, 2);
		players.get(0).updateTech(Science.TECH_4, 3);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getnPlayers() {
		return nPlayers;
	}

	public void setnPlayers(int nPlayers) {
		this.nPlayers = nPlayers;
	}

	public Gearing getGearing() {
		return gearing;
	}

	public void setGearing(Gearing gearing) {
		this.gearing = gearing;
	}

	public List<Building> getMonuments() {
		return monuments;
	}

	public void setMonuments(List<Building> monuments) {
		this.monuments = monuments;
	}

	public List<Building> getBuildingsLevel1() {
		return buildingsLevel1;
	}

	public void setBuildingsLevel1(List<Building> buildingsLevel1) {
		this.buildingsLevel1 = buildingsLevel1;
	}

	public List<Building> getBuildingsLevel2() {
		return buildingsLevel2;
	}

	public void setBuildingsLevel2(List<Building> buildingsLevel2) {
		this.buildingsLevel2 = buildingsLevel2;
	}
}
