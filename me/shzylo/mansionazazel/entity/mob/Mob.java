package me.shzylo.mansionazazelvisual.entity.mob;

import me.shzylo.mansionazazelvisual.entity.Entity;
import me.shzylo.mansionazazelvisual.gfx.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
	protected int dir = 2;
	protected boolean moving = false;
	protected boolean walking = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;

		/*if(!collision(xa, 0)) {
			x += xa;
		}
		
		if(!collision(0, ya)) {
			y += ya;
		}*/
		
		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 12 - 6) >> 4;
			int yt = ((y + ya) + c / 2 * 10 + 4) >> 4;
			if (level.getTile(xt, yt).isSolid()) solid = true;
		}
		return solid;
	}

	public void render() {

	}
}
