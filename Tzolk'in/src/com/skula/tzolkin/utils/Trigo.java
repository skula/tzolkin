package com.skula.tzolkin.utils;

import com.skula.tzolkin.models.Position;

public class Trigo {

	public static Position getPoint(int wx0, int wy0, int radius, int dAngle, int nRanks, int rank) {
		double angle0 = -90 - (360.0 / nRanks) * rank - dAngle;
		if (angle0 < -180) {
			angle0 += 360;
		}
		double x = (wx0 + radius * Math.cos(Math.toRadians(angle0) * -1));
		double y = (wy0 + radius * Math.sin(Math.toRadians(angle0) * -1));
		return new Position((int)Math.round(x), (int)Math.round(y));
	}
}