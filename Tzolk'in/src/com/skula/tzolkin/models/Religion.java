package com.skula.tzolkin.models;

import java.util.ArrayList;
import java.util.List;

public class Religion {
	public static final int TEMPLES_COUNT = 3;
	public static final int TEMPLE_RED = 0;
	public static final int TEMPLE_YELLOW = 1;
	public static final int TEMPLE_GREEN = 2;
	
	private Temple[] temples;

	public static void main(String[] args) {
		Religion reg = new Religion();
		System.out.println(reg.getPoints(0, 5));
	}

	public Religion() {
		this.temples = new Temple[3];		
		this.temples[TEMPLE_RED] = new Temple(7, new TempleStep[] {
				new TempleStep(-1, Commodity.NONE),
				new TempleStep(0, Commodity.NONE),
				new TempleStep(2, Commodity.STONE),
				new TempleStep(4, Commodity.NONE),
				new TempleStep(6, Commodity.STONE),
				new TempleStep(7, Commodity.NONE),
				new TempleStep(8, Commodity.NONE) });
		this.temples[TEMPLE_YELLOW] = new Temple(9, new TempleStep[] {
				new TempleStep(-2, Commodity.NONE),
				new TempleStep(0, Commodity.NONE),
				new TempleStep(1, Commodity.NONE),
				new TempleStep(2, Commodity.GOLD),
				new TempleStep(4, Commodity.NONE),
				new TempleStep(6, Commodity.GOLD),
				new TempleStep(9, Commodity.NONE),
				new TempleStep(12, Commodity.NONE),
				new TempleStep(13, Commodity.NONE) });
		this.temples[TEMPLE_GREEN] = new Temple(8, new TempleStep[] {
				new TempleStep(-3, Commodity.NONE),
				new TempleStep(0, Commodity.NONE),
				new TempleStep(1, Commodity.WOOD),
				new TempleStep(3, Commodity.NONE),
				new TempleStep(5, Commodity.WOOD),
				new TempleStep(7, Commodity.SKULL),
				new TempleStep(9, Commodity.NONE),
				new TempleStep(10, Commodity.NONE) });
	}

	public List<Commodity> getComodities(int temple, int step) {
		List<Commodity> res = new ArrayList<Commodity>();
		for (int i = step; i >= 1; i--) {
			if (!temples[temple].getStep(i).getComodity()
					.equals(Commodity.NONE)) {
				res.add(temples[temple].getStep(i).getComodity());
			}
		}
		return res;
	}

	public int getPoints(int temple, int step) {
		return temples[temple].getStep(step).getPoints();
	}

	public boolean isTop(int temple, int step) {
		return step == temples[temple].getSize() - 1;
	}
}
