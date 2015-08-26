package com.skula.tzolkin.services;

import java.util.List;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.skula.tzolkin.R;
import com.skula.tzolkin.cnst.PictureLibrary;
import com.skula.tzolkin.models.Building;
import com.skula.tzolkin.models.Pawn;
import com.skula.tzolkin.models.Player;
import com.skula.tzolkin.models.Position;
import com.skula.tzolkin.models.Religion;
import com.skula.tzolkin.models.Science;
import com.skula.tzolkin.utils.Trigo;

public class Drawer {
	private static final int SCREEN_WIDTH = 1280;
	private static final int SCREEN_HEIGHT = 736;
	private static final Rect SCREEN_RECT = new Rect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

	private int BACKGROUND_WIDTH;
	private int BACKGROUND_HEIGHT;

	private static final int WHEEL_GREEN_X0 = 420;
	private static final int WHEEL_GREEN_Y0 = 482;
	private static final int WHEEL_GREEN_RADIUS = 72;
	private static final int WHEEL_GREEN_DANGLE = -1;

	private static final int WHEEL_GRAY_X0 = 876;
	private static final int WHEEL_GRAY_Y0 = 312;
	private static final int WHEEL_GRAY_RADIUS = 72;
	private static final int WHEEL_GRAY_DANGLE = 67;

	private static final int WHEEL_RED_X0 = 1196;
	private static final int WHEEL_RED_Y0 = 680;
	private static final int WHEEL_RED_RADIUS = 72;
	private static final int WHEEL_RED_DANGLE = 137;

	private static final int WHEEL_YELLOW_X0 = 966;
	private static final int WHEEL_YELLOW_Y0 = 1109;
	private static final int WHEEL_YELLOW_RADIUS = 72;
	private static final int WHEEL_YELLOW_DANGLE = 205;

	private static final int WHEEL_BLUE_X0 = 460;
	private static final int WHEEL_BLUE_Y0 = 1074;
	private static final int WHEEL_BLUE_RADIUS = 112;
	private static final int WHEEL_BLUE_DANGLE = -98;

	private PictureLibrary lib;
	private GameEngine engine;
	private Paint paint;

	private String log;
	private int x;
	private int y;
	private Rect FOCUS;

	public Drawer(Resources res, GameEngine engine) {
		this.paint = new Paint();
		this.lib = new PictureLibrary(res);
		this.engine = engine;

		this.x = 0;
		this.y = 0;
		this.FOCUS = new Rect(x, y, x + SCREEN_WIDTH, y + SCREEN_HEIGHT);

		this.BACKGROUND_WIDTH = lib.get(R.drawable.background).getWidth();
		this.BACKGROUND_HEIGHT = lib.get(R.drawable.background).getHeight();
	}

	public void draw(Canvas c) {
		drawBackground(c);
		paint.setColor(Color.RED);
		//drawWheel(c);

		 drawPlayers(c);
		 drawMonuments(c, engine.getMonuments());
		 drawBuildings(c, engine.getBuildingsLevel1());
	}

	public void drawBackground(Canvas c) {
		c.drawBitmap(lib.get(R.drawable.background), FOCUS, SCREEN_RECT, paint);
	}

	private void drawPlayers(Canvas c) {
		for (Player pl : engine.getPlayers()) {
			// engrenage
			for (Pawn pa : pl.getPawns()) {
				drawPawnWheel(c, pl.getId(), pa.getWheel(), pa.getSprocket());
			}
			// temples
			 drawPawnReligion(c, pl);
			// technologies
			drawPawnScience(c, pl);
		}
	}

	private void drawPawnReligion(Canvas c, Player p) {
		int dy = 45;
		int x = 1500;
		int y = 535;
		
		for(int i=0; i<Religion.TEMPLES_COUNT; i++){
			int rank = p.getTempleStep(i);
			c.drawRect(relates(new Rect(x, y - dy * rank, x + 20, y - dy * rank + 20)), paint);
			x += 155;
		}
	}

	private void drawPawnScience(Canvas c, Player p) {
		int dx = 120;
		int x = 1500;
		int y = 610;
		int x1;
		int sep = 50;
		
		for(int i=0; i<Science.TECHOLOGIES_COUNT; i++){
			int rank = p.getTechnoRank(i);
			x1=rank==0?x:x+sep+(rank-1)*dx;
			c.drawRect(relates(new Rect(x1, y , x1 + 20 , y  + 20)), paint);
			y += 100;
		}
	}

	private void drawMonuments(Canvas c, List<Building> monuments) {
		int x = 1222;
		int y = 1012;
		int dx = 111 + 11;
		for (Building m : monuments) {
			c.drawRect(relates(new Rect(x, y, x + 113, y + 145)), paint);
			x += dx;
		}
	}

	private void drawBuildings(Canvas c, List<Building> buildings) {
		int x = 1222;
		int y = 1190;
		int dx = 111 + 11;
		for (Building m : buildings) {
			c.drawRect(relates(new Rect(x, y, x + 113, y + 145)), paint);
			x += dx;
		}
	}

	private void drawPawnWheel(Canvas c, int playerId, int wheelId, int rank){
		Position p = null;
		Rect r = null;
		switch(wheelId){
		case 0:
			p = Trigo.getPoint(WHEEL_GREEN_X0, WHEEL_GREEN_Y0, WHEEL_GREEN_RADIUS, WHEEL_GREEN_DANGLE, 10, rank);
			break;
		case 1:
			p = Trigo.getPoint(WHEEL_GRAY_X0, WHEEL_GRAY_Y0, WHEEL_GRAY_RADIUS, WHEEL_GRAY_DANGLE, 10, rank);
			break;
		case 2:
			p = Trigo.getPoint(WHEEL_RED_X0, WHEEL_RED_Y0, WHEEL_RED_RADIUS, WHEEL_RED_DANGLE, 10, rank);
			break;
		case 3:
			p = Trigo.getPoint(WHEEL_YELLOW_X0, WHEEL_YELLOW_Y0, WHEEL_YELLOW_RADIUS, WHEEL_YELLOW_DANGLE, 10, rank);
			break;
		case 4:
			p = Trigo.getPoint(WHEEL_BLUE_X0, WHEEL_BLUE_Y0, WHEEL_BLUE_RADIUS, WHEEL_BLUE_DANGLE, 13, rank);
			break;
		default:
			break;
		}
		
		r = getRectFromPoint(p);
		c.drawRect(relates(r), paint);
	}

	public void drawWheel(Canvas c) {
		Rect r = getRectFromPoint(WHEEL_GREEN_X0, WHEEL_GREEN_Y0);
		c.drawRect(relates(r), paint);

		for (int i = 0; i < 8; i++) {
			Position p = Trigo.getPoint(WHEEL_GREEN_X0, WHEEL_GREEN_Y0, WHEEL_GREEN_RADIUS, WHEEL_GREEN_DANGLE, 10, i);
			r = getRectFromPoint(p);
			c.drawRect(relates(r), paint);
		}

		r = getRectFromPoint(WHEEL_GRAY_X0, WHEEL_GRAY_Y0);
		c.drawRect(relates(r), paint);

		for (int i = 0; i < 8; i++) {
			Position p = Trigo.getPoint(WHEEL_GRAY_X0, WHEEL_GRAY_Y0, WHEEL_GRAY_RADIUS, WHEEL_GRAY_DANGLE, 10, i);
			r = getRectFromPoint(p);
			c.drawRect(relates(r), paint);
		}

		r = getRectFromPoint(WHEEL_RED_X0, WHEEL_RED_Y0);
		c.drawRect(relates(r), paint);

		for (int i = 0; i < 8; i++) {
			Position p = Trigo.getPoint(WHEEL_RED_X0, WHEEL_RED_Y0, WHEEL_RED_RADIUS, WHEEL_RED_DANGLE, 10, i);
			r = getRectFromPoint(p);
			c.drawRect(relates(r), paint);
		}

		r = getRectFromPoint(WHEEL_YELLOW_X0, WHEEL_YELLOW_Y0);
		c.drawRect(relates(r), paint);

		for (int i = 0; i < 8; i++) {
			Position p = Trigo.getPoint(WHEEL_YELLOW_X0, WHEEL_YELLOW_Y0, WHEEL_YELLOW_RADIUS, WHEEL_YELLOW_DANGLE, 10,
					i);
			r = getRectFromPoint(p);
			c.drawRect(relates(r), paint);
		}

		r = getRectFromPoint(WHEEL_BLUE_X0, WHEEL_BLUE_Y0);
		c.drawRect(relates(r), paint);

		for (int i = 0; i < 11; i++) {
			Position p = Trigo.getPoint(WHEEL_BLUE_X0, WHEEL_BLUE_Y0, WHEEL_BLUE_RADIUS, WHEEL_BLUE_DANGLE, 13, i);
			r = getRectFromPoint(p);
			c.drawRect(relates(r), paint);
		}
	}

	private Rect getRectFromPoint(Position p) {
		return getRectFromPoint(p.getX(), p.getY());
	}

	private Rect getRectFromPoint(int x, int y) {
		return new Rect(x - 1, y - 1, x + 1, y + 1);
	}

	private boolean isOnFocus(Rect r) {
		return FOCUS.contains(r) || Rect.intersects(FOCUS, r);
	}

	private Rect relates(Rect r) {
		return new Rect(r.left - x, r.top - y, r.right - x, r.bottom - y);
	}

	public void moveX(int dx) {
		if (this.x + dx < 0) {
			this.x = 0;
		} else if (this.x + dx > BACKGROUND_WIDTH - SCREEN_WIDTH) {
			this.x = BACKGROUND_WIDTH - SCREEN_WIDTH;
		} else {
			this.x += dx;
		}

		FOCUS = new Rect(x, y, x + SCREEN_WIDTH, y + SCREEN_HEIGHT);
	}

	public void moveY(int dy) {
		if (this.y + dy < 0) {
			this.y = 0;
		} else if (this.y + dy > BACKGROUND_HEIGHT - SCREEN_HEIGHT) {
			this.y = BACKGROUND_HEIGHT - SCREEN_HEIGHT;
		} else {
			this.y += dy;
		}

		FOCUS = new Rect(x, y, x + SCREEN_WIDTH, y + SCREEN_HEIGHT);
	}
}