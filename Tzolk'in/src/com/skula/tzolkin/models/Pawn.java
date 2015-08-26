package com.skula.tzolkin.models;

public class Pawn {
	private int wheel;
	private int rank;

	public Pawn(int wheel, int rank) {
		this.wheel = wheel;
		this.rank = rank;
	}
	
	public void move(){
		this.rank++;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getSprocket() {
		return rank;
	}

	public void setSprocket(int sprocket) {
		this.rank = sprocket;
	}
}
