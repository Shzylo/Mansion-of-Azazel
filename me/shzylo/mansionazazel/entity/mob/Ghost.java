package me.shzylo.mansionazazel.entity.mob;

import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.graphics.Sprite;
import me.shzylo.mansionazazel.level.TileCoordinate;

/**
 * Represents a Ghost
 */
public class Ghost extends Mob {
	private Sprite sprite;
	private Player player;
	private TileCoordinate tileCoord = new TileCoordinate(x, y);
	private short anim = 0;
	private boolean walking = false;

	/**
	 * Main constructor for Ghost
	 * 
	 * @param x
	 *            The horizontal spawn
	 * @param y
	 *            The vertical spawn
	 * @param player
	 *            The player to follow
	 */
	public Ghost(int x, int y, Player player) {
		this.x = x;
		this.y = y;
		this.player = player;
		sprite = Sprite.ghost;
		dir = 2;
	}

	@Override
	public void update() {
		int xa = 0, ya = 0;

		if (anim < 1000)
			anim++;
		else
			anim = 0;

		int dist = 4;
		if (player.getX() + tileCoord.dist(dist) < getX() || player.getX() - tileCoord.dist(dist) > getX() || player.getY() + tileCoord.dist(dist) < getY()
				|| player.getY() - tileCoord.dist(dist) > getY()) {
			if (player.getX() > getX())
				xa++;
			if (player.getX() < getX())
				xa--;
			if (player.getY() > getY())
				ya++;
			if (player.getY() < getY())
				ya--;
		}

		int distX = player.getX() - getX();
		int distY = player.getY() - getY();

		if (Math.abs(distX) > Math.abs(distY)) {
			if (distX > 0) {
				dir = 1;
			} else {
				dir = 3;
			}
		} else {
			if (distY > 0) {
				dir = 2;
			} else {
				dir = 0;
			}
		}

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else
			walking = false;
	}

	@Override
	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) {
			sprite = Sprite.ghost;
			if (walking) {
				if (anim % 60 > 45)
					sprite = Sprite.ghost;
				else if (anim % 60 > 30)
					sprite = Sprite.ghost;
				else if (anim % 60 > 15)
					sprite = Sprite.ghost;
				else
					sprite = Sprite.ghost;
			}
		} else if (dir == 1) {
			sprite = Sprite.ghost;
			if (walking) {
				if (anim % 60 > 45)
					sprite = Sprite.ghost;
				else if (anim % 60 > 30)
					sprite = Sprite.ghost;
				else if (anim % 60 > 15)
					sprite = Sprite.ghost;
				else
					sprite = Sprite.ghost;
			}
			flip = 1;
		} else if (dir == 2) {
			sprite = Sprite.ghost;
			if (walking) {
				if (anim % 60 > 45)
					sprite = Sprite.ghost;
				else if (anim % 60 > 30)
					sprite = Sprite.ghost;
				else if (anim % 60 > 15)
					sprite = Sprite.ghost;
				else
					sprite = Sprite.ghost;
			}
		} else if (dir == 3) {
			sprite = Sprite.ghost;
			if (walking) {
				if (anim % 60 > 45)
					sprite = Sprite.ghost;
				else if (anim % 60 > 30)
					sprite = Sprite.ghost;
				else if (anim % 60 > 15)
					sprite = Sprite.ghost;
				else
					sprite = Sprite.ghost;
			}
		}
		screen.renderGhost(x - 16, y - 16, sprite, flip);
	}
}
