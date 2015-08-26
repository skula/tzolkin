package com.skula.tzolkin.models;

import java.util.ArrayList;
import java.util.List;

public class Temple {
	private int size;
	private TempleStep[] steps;

	public Temple(int size, TempleStep[] steps) {
		this.size = size;
		this.steps = steps;
	}

	public List<Commodity> getComodities(int step) {
		List<Commodity> res = new ArrayList<Commodity>();
		for (int i = step; i >= 1; i--) {
			if (!steps[i].getComodity().equals(Commodity.NONE)) {
				res.add(steps[i].getComodity());
			}
		}
		return res;
	}

	public int getPoints(int step) {
		return steps[step].getPoints();
	}
	
	public boolean isTop(int step) {
		return step == size - 1;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public TempleStep getStep(int step) {
		return steps[step];
	}
	
	public TempleStep[] getSteps() {
		return steps;
	}

	public void setSteps(TempleStep[] steps) {
		this.steps = steps;
	}
}
