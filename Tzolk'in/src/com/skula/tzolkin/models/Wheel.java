package com.skula.tzolkin.models;

public class Wheel {
	public static final Wheel WHEEL_GREEN = new Wheel(0, 8, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
	public static final Wheel WHEEL_GRAY = new Wheel(1, 8, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
	public static final Wheel WHEEL_RED = new Wheel(2, 8, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
	public static final Wheel WHEEL_YELLOW = new Wheel(3, 8, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
	public static final Wheel WHEEL_BLUE = new Wheel(4, 11, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
	
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
