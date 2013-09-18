package me.shzylo.mansionazazel.entity.mob;

import me.shzylo.mansionazazel.entity.Entity;
import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.graphics.Sprite;

/**
 * Abstract class for all mob entities
 */
public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected short dir = 0;
	protected boolean moving = false;
	protected boolean walking = false;
	
	/**
	 * Move the entity
	 * 
	 * @param xa
	 *           Horizontal axis for the mob to move on
	 * @param ya
	 *           Verical axis for the mob to move on
	 */
	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;
		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;

		/*
		 * if(!collision(xa, 0)) { x += xa; }
		 * 
		 * if(!collision(0, ya)) { y += ya; }
		 */

		if (!tileCollision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	/**
	 * Update the mob
	 */
	public abstract void update();

	/**
	 * Check for collision for tiles
	 * 
	 * @param xa
	 *           Horizontal collision
	 * @param ya
	 *           Vertical collision
	 * @return If there is collision
	 */
	private boolean tileCollision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 12 - 6) >> 4;
			int yt = ((y + ya) + c / 2 * 10 + 4) >> 4;
			if (level.getTile(xt, yt).isSolid())
				solid = true;
		}
		return solid;
	}

	/**
	 * Render the mob on the screen
	 */
	public void render(Screen screen) {
	}

	/**
	 * Returns the X location of a mob
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns the Y location of a mob
	 */
	public int getY() {
		return y;
	}
}
