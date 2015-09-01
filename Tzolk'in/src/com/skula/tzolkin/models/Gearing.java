package com.skula.tzolkin.models;

import java.util.HashMap;
import java.util.Map;

public class Gearing {
	private static final int TURN_COUNT = 26;
	public static final int FIELD_CORN = 0;
	public static final int FIELD_WOOD = 1;
	
	private int position;
	private boolean[] skulls;
	private Map<Integer, Integer[]> fields;

	private static Wheel[] wheels;
	static{
		wheels = new Wheel[5];
		wheels[Wheel.GREEN] = new Wheel(0, 8, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
		wheels[Wheel.GRAY] = new Wheel(1, 8, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
		wheels[Wheel.RED] = new Wheel(2, 8, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
		wheels[Wheel.YELLOW] = new Wheel(3, 8, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
		wheels[Wheel.BLUE] = new Wheel(4, 11, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
	}
	
	public Gearing() {
		this.position = 1;
		
		this.skulls = new boolean[9];
		for (int i = 0; i < 9; i++) {
			skulls[i] = false;
		}

		this.fields = new HashMap<Integer, Integer[]>();
		this.fields.put(2, new Integer[] { FIELD_CORN, FIELD_CORN, FIELD_CORN,
				FIELD_CORN });
		this.fields.put(3, new Integer[] { FIELD_WOOD, FIELD_WOOD, FIELD_WOOD,
				FIELD_WOOD });
		this.fields.put(4, new Integer[] { FIELD_WOOD, FIELD_WOOD, FIELD_WOOD,
				FIELD_WOOD });
		this.fields.put(4, new Integer[] { FIELD_WOOD, FIELD_WOOD, FIELD_WOOD,
				FIELD_WOOD });
	}

	public static int getEffect(int wheelId, int rank) {
		return wheels[wheelId].getEffect(rank);
	}

	public static boolean canMove(Pawn p) {
		return p.getSprocket() < wheels[p.getWheel()].getSize();
	}
	
	public void turn(){
		position++;
	}

	public void burnWood(int rank) {
		Integer field[] = fields.get(rank);
		for (int i = 0; i < 4; i++) {
			if (field[i] == FIELD_WOOD) {
				field[i] = FIELD_CORN;
				break;
			}
		}
	}
}
