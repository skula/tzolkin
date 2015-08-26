package com.skula.tzolkin.models;

public class Science {
	public static final int TECHOLOGIES_COUNT = 4;
	public static final int TECH_1 = 0;
	public static final int TECH_2 = 1;
	public static final int TECH_3 = 2;
	public static final int TECH_4 = 3;
	
	private int[][] technologies;
	
	public static void main(String[] args) {

	}

	public Science(){
		this.technologies = new int[4][4];
	}
}
