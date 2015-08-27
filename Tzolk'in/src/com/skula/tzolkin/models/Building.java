package com.skula.tzolkin.models;

import java.util.ArrayList;
import java.util.List;

public class Building {
	public static final int BLUE = 0;
	public static final int GRAY = 1;
	public static final int GREEN = 2;
	public static final int YELLOW = 3;

	private int id;
	private int drawableId;
	private int color;
	private int nWood;
	private int nStone;
	private int nGold;
	private int nSkulls;

	public static List<Building> MONUMENTS;
	public static List<Building> BUILDINGS_LEVEL1;
	public static List<Building> BUILDINGS_LEVEL2;

	static {
		MONUMENTS = new ArrayList<Building>();
		MONUMENTS.add(new Building(0, 0, BLUE, 0, 0, 4, 1));
		MONUMENTS.add(new Building(1, 0, GREEN, 2, 1, 3, 0));
		MONUMENTS.add(new Building(2, 0, GRAY, 1, 0, 4, 0));
		MONUMENTS.add(new Building(3, 0, GREEN, 3, 0, 3, 0));
		MONUMENTS.add(new Building(4, 0, GRAY, 2, 2, 2, 0));
		MONUMENTS.add(new Building(5, 0, GRAY, 3, 2, 1, 0));
		MONUMENTS.add(new Building(6, 0, GREEN, 2, 3, 1, 0));
		MONUMENTS.add(new Building(7, 0, BLUE, 0, 4, 3, 0));
		MONUMENTS.add(new Building(8, 0, GREEN, 1, 1, 3, 0));
		MONUMENTS.add(new Building(9, 0, BLUE, 0, 3, 3, 0));
		MONUMENTS.add(new Building(10, 0, GRAY, 1, 1, 4, 0));
		MONUMENTS.add(new Building(11, 0, BLUE, 0, 2, 3, 0));
		MONUMENTS.add(new Building(12, 0, GRAY, 1, 3, 2, 0));

		BUILDINGS_LEVEL1 = new ArrayList<Building>();
		BUILDINGS_LEVEL1.add(new Building(0, 0, YELLOW, 4, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(1, 0, YELLOW, 1, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(2, 0, GREEN, 2, 1, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(3, 0, GRAY, 1, 0, 1, 0));
		BUILDINGS_LEVEL1.add(new Building(4, 0, YELLOW, 1, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(5, 0, GRAY, 2, 1, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(6, 0, GREEN, 3, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(7, 0, YELLOW, 1, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(8, 0, GRAY, 1, 2, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(9, 0, BLUE, 0, 0, 1, 0));
		BUILDINGS_LEVEL1.add(new Building(10, 0, GREEN, 2, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(11, 0, GREEN, 1, 1, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(12, 0, BLUE, 0, 1, 1, 0));
		BUILDINGS_LEVEL1.add(new Building(13, 0, YELLOW, 4, 0, 0, 0));

		BUILDINGS_LEVEL2 = new ArrayList<Building>();
		BUILDINGS_LEVEL1.add(new Building(14, 0, GREEN, 0, 2, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(15, 0, GREEN, 3, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(16, 0, GREEN, 0, 1, 2, 0));
		BUILDINGS_LEVEL1.add(new Building(17, 0, GREEN, 0, 3, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(18, 0, GREEN, 2, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(19, 0, GREEN, 2, 1, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(20, 0, GREEN, 2, 2, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(21, 0, GREEN, 2, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(22, 0, GREEN, 2, 1, 1, 0));
		BUILDINGS_LEVEL1.add(new Building(23, 0, GREEN, 1, 1, 1, 0));
		BUILDINGS_LEVEL1.add(new Building(24, 0, GREEN, 1, 0, 2, 0));
		BUILDINGS_LEVEL1.add(new Building(25, 0, GREEN, 1, 2, 1, 0));
		BUILDINGS_LEVEL1.add(new Building(26, 0, GREEN, 0, 1, 1, 0));
		BUILDINGS_LEVEL1.add(new Building(27, 0, GREEN, 3, 1, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(28, 0, GREEN, 0, 2, 1, 0));
		BUILDINGS_LEVEL1.add(new Building(29, 0, GREEN, 2, 0, 0, 0));
		BUILDINGS_LEVEL1.add(new Building(30, 0, GREEN, 0, 0, 3, 0));
		BUILDINGS_LEVEL1.add(new Building(31, 0, GREEN, 0, 0, 2, 0));
	}

	public Building(int id, int drawableId, int color, int nWood, int nStone, int nGold, int nSkulls) {
		this.id = id;
		this.drawableId = drawableId;
		this.color = color;
		this.nWood = nWood;
		this.nStone = nStone;
		this.nGold = nGold;
		this.nSkulls = nSkulls;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDrawableId() {
		return drawableId;
	}

	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
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
}
