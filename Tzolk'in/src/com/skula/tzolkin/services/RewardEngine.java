package com.skula.tzolkin.services;

import com.skula.tzolkin.enums.Commodity;
import com.skula.tzolkin.models.Building;
import com.skula.tzolkin.models.Pawn;
import com.skula.tzolkin.models.Player;
import com.skula.tzolkin.models.Religion;
import com.skula.tzolkin.models.Science;
import com.skula.tzolkin.models.Wheel;

public class RewardEngine {

	public static void handleWheelsReward(Pawn pa, Player pl) {
		if(pa.getWheel()==Wheel.GREEN){
			switch(pa.getSprocket()){
			case 0:
				break;
			case 1:
				pl.addCorn(3);
				break;
			case 2:
				// TODO: choix bois/mais
				break;
			case 3:
				// TODO: choix bois/mais
				break;
			case 4:
				// TODO: choix bois/mais
				break;
			case 5:
				// TODO: choix bois/mais
				break;
			case 6:
				// TODO: choix de la case				
				break;
			case 7:
				// TODO: choix de la case	
				break;
			}
		}else if(pa.getWheel()==Wheel.GRAY){
			switch(pa.getSprocket()){
			case 0:
				break;
			case 1:
				pl.addWood(1);
				break;
			case 2:
				pl.addStone(1);
				pl.addCorn(1);
				break;
			case 3:
				pl.addGold(1);
				pl.addCorn(2);
				break;
			case 4:
				pl.addSkulls(1);
				break;
			case 5:
				pl.addGold(1);
				pl.addStone(1);
				pl.addCorn(2);
				break;
			case 6:			
				// TODO: choix de la case
				break;
			case 7:
				break;
			}
		}else if(pa.getWheel()==Wheel.RED){
		
		}else if(pa.getWheel()==Wheel.YELLOW){
		
		}else {
		
		}
	}

	public static void handleTemplesReward(int phase, Religion rel, Player pl) {
		// TODO: calculer phase
		int step = 0;
		if (phase == GameEngine.PHASE_BLUE) {
			for (int i = 0; i < Religion.TEMPLES_COUNT; i++) {
				step = pl.getTempleStep(i);
				for (Commodity c : rel.getComodities(i, step)) {
					switch (c) {
					case WOOD:
						pl.addWood(1);
						break;
					case STONE:
						pl.addStone(1);
						break;
					case GOLD:
						pl.addGold(1);
						break;
					case SKULL:
						pl.addSkulls(1);
						break;
					default:
						break;
					}
				}
			}
		} else {
			for (int i = 0; i < Religion.TEMPLES_COUNT; i++) {
				step = pl.getTempleStep(i);
				pl.addPoints(rel.getPoints(i, step));
			}
		}
	}

	public static void handleBuildingReward(int id, Player pl, int choice) {
		switch (id) {
		/********** LEVEL 1 **********/
		case 0:
			// do nothing
			break;
		case 1:
			// do nothing
			break;
		case 2:
			pl.addGold(1);
			pl.updateTech(Science.TECH_2, 1);
			break;
		case 3:
			pl.updateTemple(choice, 1);
			break;
		case 4:
			// do nothing
			break;
		case 5:
			pl.updateTemple(Religion.TEMPLE_RED, 1);
			pl.updateTemple(Religion.TEMPLE_YELLOW, 1);
			break;
		case 6:
			pl.addStone(1);
			pl.updateTech(Science.TECH_1, 1);
			break;
		case 7:
			// do nothing
			break;
		case 8:
			pl.updateTemple(Religion.TEMPLE_RED, 1);
			pl.updateTemple(Religion.TEMPLE_GREEN, 1);
			break;
		case 9:
			pl.updateTech(Science.TECH_3, 1);
			break;
		case 10:
			pl.updateTech(Science.TECH_1, 1);
			break;
		case 11:
			pl.updateTech(Science.TECH_2, 1);
			pl.addCorn(1);
			break;
		case 12:
			pl.updateTech(Science.TECH_4, 1);
			pl.updateTemple(Religion.TEMPLE_GREEN, 1);
			break;
		case 13:
			// do nothing
			break;
		/********** LEVEL 2 **********/
		case 14:
			pl.updateTemple(Religion.TEMPLE_RED, 2);
			pl.addPoints(2);
			break;
		case 15:
			pl.updateTech(choice, 1);
			pl.addStone(1);
			break;
		case 16:
			pl.updateTech(choice, 2);
			break;
		case 17:
			// TODO: choix echange ressources <=> mais
			break;
		case 18:
			// do nothing
			break;
		case 19:
			pl.updateTech(choice, 1);
			pl.addGold(1);
			break;
		case 20:
			pl.updateTech(choice, 1);
			pl.addSkulls(1);
			break;
		case 21:
			// do nothing
			break;
		case 22:
			// TODO: ??? arc-een-ciel
			break;
		case 23:
			pl.addPawns(1);
			pl.addPoints(6);
			break;
		case 24:
			pl.addPoints(8);
			break;
		case 25:
			pl.addPoints(3);
			pl.updateTemple(Religion.TEMPLE_RED, 1);
			pl.updateTemple(Religion.TEMPLE_YELLOW, 1);
			pl.updateTemple(Religion.TEMPLE_GREEN, 1);
			break;
		case 26:
			pl.updateTech(Science.TECH_3, 1);
			pl.addPoints(3);
			break;
		case 27:
			pl.updateTech(choice, 1);
			pl.addCorn(6);
			break;
		case 28:
			pl.updateTech(Science.TECH_4, 1);
			pl.updateTemple(Religion.TEMPLE_RED, 1);
			pl.updateTemple(Religion.TEMPLE_GREEN, 1);
			break;
		case 29:
			// do nothing
			break;
		case 30:
			pl.updateTemple(Religion.TEMPLE_YELLOW, 2);
			pl.addPoints(4);
			break;
		case 31:
			pl.updateTemple(Religion.TEMPLE_GREEN, 2);
			pl.addPoints(3);
			break;
		default:
			break;
		}
	}

	public static void handleMonumentsReward(int nPlayers, Player pl) {
		for (Building m : pl.getMonuments()) {
			switch (m.getId()) {
			case 0:
				pl.addPoints(pl.getnPlacedSkulls() * 3);
				break;
			case 1:
				for (int i = 0; i < Science.TECHNOLOGIES_COUNT; i++) {
					pl.addPoints(pl.getTechnoRank(i) * 3);
				}
				break;
			case 2:
				pl.addPoints(pl.getnWoodTiles() * 4);
				break;
			case 3:
				switch (pl.getnPawns()) {
				case 4:
					pl.addPoints(6);
					break;
				case 5:
					pl.addPoints(12);
					break;
				case 6:
					pl.addPoints(18);
					break;
				default:
					break;
				}
				break;
			case 4:
				switch (nPlayers) {
				case 2:
					pl.addPoints(6);
					break;
				case 3:
					pl.addPoints(5);
					break;
				case 4:
					pl.addPoints(4);
					break;
				default:
					break;
				}
				break;
			case 5:
				for (Building b1 : pl.getBuildings()) {
					if (b1.getColor() == Building.GRAY) {
						pl.addPoints(4);
					}
				}
				for (Building m1 : pl.getBuildings()) {
					if (m1.getColor() == Building.GRAY) {
						pl.addPoints(4);
					}
				}
				break;
			case 6:
				for (Building b1 : pl.getBuildings()) {
					if (b1.getColor() == Building.GREEN) {
						pl.addPoints(4);
					}
				}
				for (Building m1 : pl.getBuildings()) {
					if (m1.getColor() == Building.GREEN) {
						pl.addPoints(4);
					}
				}
				break;
			case 7:
				for (int i = 0; i < Religion.TEMPLES_COUNT; i++) {
					pl.addPoints(Religion.getPoints(i, pl.getTempleStep(i)));
				}
				break;
			case 8:
				int n = 0;
				for (int i = 0; i < Science.TECHNOLOGIES_COUNT; i++) {
					if (pl.getTechnoRank(i) == 3) {
						n++;
					}
				}
				switch (n) {
				case 1:
					pl.addPoints(9);
					break;
				case 2:
					pl.addPoints(20);
					break;
				case 3:
					pl.addPoints(33);
					break;
				case 4:
					pl.addPoints(33);
					break;
				default:
					break;
				}
				break;
			case 9:
				int max = 0;
				for (int i = 0; i < Religion.TEMPLES_COUNT; i++) {
					if (pl.getTempleStep(i) > max) {
						max = pl.getTempleStep(i);
					}
				}
				pl.addPoints(max * 3);
				break;
			case 10:
				pl.addPoints(pl.getnCornTiles() * 4);
				break;
			case 11:
				for (Building b1 : pl.getMonuments()) {
					if (b1.getColor() == Building.BLUE) {
						pl.addPoints(4);
					}
				}
				for (Building m1 : pl.getBuildings()) {
					if (m1.getColor() == Building.BLUE) {
						pl.addPoints(4);
					}
				}
				break;
			case 12:
				pl.addPoints(pl.getMonuments().size());
				pl.addPoints(pl.getBuildings().size());
				break;
			default:
				break;
			}
		}
	}
}
