package com.skula.tzolkin.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	private int score;
	private int nPawns;
	private List<Pawn> pawns;
	// constructions
	private List<Building> buildings;
	private List<Building> monuments;
	// denrees
	private int nCorn;
	private int nCornTiles;
	private int nWood;
	private int nWoodTiles;
	private int nStone;
	private int nGold;
	private int nSkulls;
	private int nPlacedSkulls;
	// temples
	private int temples[];
	// technologies
	private int technologies[];

	public Player(int id) {
		this.id = id;
		this.score = 0;
		this.nPawns = 3;
		this.pawns = new ArrayList<Pawn>();
		this.buildings = new ArrayList<Building>();
		this.monuments = new ArrayList<Building>();
		this.nCorn = 0;
		this.nCornTiles = 0;
		this.nWood = 0;
		this.nCornTiles = 0;
		this.nStone = 0;
		this.nGold = 0;
		this.nSkulls = 0;
		this.nPlacedSkulls = 0;

		this.temples = new int[Religion.TEMPLES_COUNT];
		for (int i = 0; i < Religion.TEMPLES_COUNT; i++) {
			temples[i] = 1;
		}

		this.technologies = new int[Science.TECHNOLOGIES_COUNT];
		for (int i = 0; i < Science.TECHNOLOGIES_COUNT; i++) {
			technologies[i] = 0;
		}
	}

	public boolean canBuy(Building b) {
		if (nWood < b.getnWood()) {
			return false;
		}
		if (nStone < b.getnStone()) {
			return false;
		}
		if (nGold < b.getnGold()) {
			return false;
		}
		if (nSkulls < b.getnSkulls()) {
			return false;
		}
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void addPoints(int n) {
		this.score += n;
	}

	public int getnPawns() {
		return nPawns;
	}

	public void addPawns(int nPawns) {
		this.nPawns += nPawns;
	}

	public List<Pawn> getPawns() {
		return pawns;
	}

	public void addPawns(Pawn pawn) {
		this.pawns.add(pawn);
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void addBuildings(Building b) {
		this.buildings.add(b);
	}

	public List<Building> getMonuments() {
		return monuments;
	}

	public void addMonuments(Building b) {
		this.monuments.add(b);
	}

	public int getnCorn() {
		return nCorn;
	}

	public void addCorn(int nCorn) {
		this.nCorn += nCorn;
	}

	public int getCornTax() {
		// TODO: calculer en fonction des batiments
		return 0;
	}

	public int getnWood() {
		return nWood;
	}

	public void addWood(int nWood) {
		this.nWood += nWood;
	}

	public int getnStone() {
		return nStone;
	}

	public void addStone(int nStone) {
		this.nStone += nStone;
	}

	public int getnGold() {
		return nGold;
	}

	public void addGold(int nGold) {
		this.nGold += nGold;
	}

	public int getnSkulls() {
		return nSkulls;
	}

	public void addSkulls(int nSkulls) {
		this.nSkulls += nSkulls;
	}

	public int getnPlacedSkulls() {
		return nPlacedSkulls;
	}

	public void addPlacedSkulls(int nPlacedSkulls) {
		this.nPlacedSkulls += nPlacedSkulls;
	}

	public int getTempleStep(int temple) {
		return temples[temple];
	}

	public int getTechnoRank(int tech) {
		return technologies[tech];
	}

	public void updateTech(int tech, int nStep) {
		// TODO: gérer si dernier cran
		technologies[tech] += nStep;
	}

	public void updateTemple(int temple, int nStep) {
		// TODO: gérer si derniere marche
		temples[temple] += nStep;
	}

	public int getnCornTiles() {
		return nCornTiles;
	}

	public void addCornTiles(int nCornTiles) {
		this.nCornTiles += nCornTiles;
	}

	public int getnWoodTiles() {
		return nWoodTiles;
	}

	public void addWoodTiles(int nWoodTiles) {
		this.nWoodTiles += nWoodTiles;
	}
}
