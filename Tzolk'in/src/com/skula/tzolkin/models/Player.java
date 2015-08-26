package com.skula.tzolkin.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	private int score;
	private int nPawns;
	private int nPawnCost;
	private List<Pawn> pawns;
	// constructions
	private List<Building> buildings;
	private List<Building> monuments;
	// denrees
	private int nCorn;
	private int nWood;
	private int nStone;
	private int nGold;
	private int nSkulls;
	// temples
	private int temples[];
	// technologies
	private int technologies[];

	public Player(int id) {
		this.id = id;
		this.score = 0;
		this.nPawns = 3;
		this.nPawnCost = 6;
		this.pawns = new ArrayList<Pawn>();
		this.buildings = new ArrayList<Building>();
		this.monuments = new ArrayList<Building>();
		this.nCorn = 0;
		this.nWood = 0;
		this.nStone = 0;
		this.nGold = 0;
		this.nSkulls = 0;
		
		this.temples = new int[Religion.TEMPLES_COUNT];
		for(int i =0; i<Religion.TEMPLES_COUNT; i++){
			temples[i] = 1;
		}
		
		this.technologies = new int[Science.TECHOLOGIES_COUNT];
		for(int i =0; i<Science.TECHOLOGIES_COUNT; i++){
			technologies[i] = 0;
		}
	}
	
	public boolean canBuy(Building b){
		if(nWood<b.getnWood()){
			return false;
		}
		if(nStone<b.getnStone()){
			return false;
		}
		if(nGold<b.getnGold()){
			return false;
		}
		if(nSkulls<b.getnSkulls()){
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

	public void setScore(int score) {
		this.score = score;
	}

	public int getnPawns() {
		return nPawns;
	}

	public void setnPawns(int nPawns) {
		this.nPawns = nPawns;
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

	public void addBuildings(Building building) {
		this.buildings.add(building);
	}

	public List<Building> getMonuments() {
		return monuments;
	}

	public void addMonuments(Building monument) {
		this.monuments.add(monument);
	}

	public int getnCorn() {
		return nCorn;
	}

	public void setnCorn(int nCorn) {
		this.nCorn = nCorn;
	}

	public int getnWood() {
		return nWood;
	}

	public void setnWood(int nWood) {
		this.nWood = nWood;
	}

	public int getnStone() {
		return nStone;
	}

	public void setnStone(int nStone) {
		this.nStone = nStone;
	}

	public int getnGold() {
		return nGold;
	}

	public void setnGold(int nGold) {
		this.nGold = nGold;
	}

	public int getnSkulls() {
		return nSkulls;
	}

	public void setnSkulls(int nSkulls) {
		this.nSkulls = nSkulls;
	}
	
	public int getTempleStep(int temple){
		return temples[temple];
	}

	public int getTechnoRank(int tech){
		return technologies[tech];
	}
	
	public void updateTech(int tech, int nStep){
		technologies[tech]+=nStep;
	}

	public void updateTemple(int temple, int nStep){
		temples[temple]+=nStep;
	}
}
