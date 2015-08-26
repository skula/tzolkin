package com.skula.tzolkin.models;

public class TempleStep {
	private int points;
	private Commodity comodity;

	public TempleStep(int points, Commodity comodity) {
		this.points = points;
		this.comodity = comodity;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Commodity getComodity() {
		return comodity;
	}

	public void setComodity(Commodity comodity) {
		this.comodity = comodity;
	}
}
