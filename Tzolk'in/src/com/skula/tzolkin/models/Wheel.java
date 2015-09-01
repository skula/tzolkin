package com.skula.tzolkin.models;

public class Wheel {
	public static final int GREEN = 0;
	public static final int GRAY = 1;
	public static final int RED = 2;
	public static final int YELLOW = 3;
	public static final int BLUE = 4;
	
	private int id;
	private int size;
	private int effects[];
	
	public Wheel(int id, int size, int effects[]) {
		this.id = id;
		this.size = size;
		this.effects = effects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public int getEffect(int n) {
		return effects[n];
	}
	
	public int[] getEffects() {
		return effects;
	}
}
