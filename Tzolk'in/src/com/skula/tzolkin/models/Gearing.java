package com.skula.tzolkin.models;

import java.util.HashMap;
import java.util.Map;

public class Gearing {
	private static final int TURN_SIZE = 26;
	public static final int FIELD_CORN = 0;
	public static final int FIELD_WOOD = 1;

	private int position;
	private Wheel[] wheels;
	private boolean[] skulls;
	private Map<Integer, Integer[]> fields;

	public static void main(String[] args) {

	}

	public Gearing() {
		this.position = 1;

		this.wheels = new Wheel[5];
		this.wheels[0] = Wheel.WHEEL_GREEN;
		this.wheels[1] = Wheel.WHEEL_GRAY;
		this.wheels[2] = Wheel.WHEEL_RED;
		this.wheels[3] = Wheel.WHEEL_YELLOW;
		this.wheels[4] = Wheel.WHEEL_BLUE;

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

	public int getEffect(int wheelId, int rank) {
		return wheels[wheelId].getEffect(rank);
	}

	public boolean canMove(Pawn s) {
		return s.getSprocket() < wheels[s.getWheel()].getSize();
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
