package me.shzylo.mansionazazel.level.tile;

import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.graphics.Sprite;

/**
 * First piece of the car<br><br>
 * <b>Solid Tile</b>
 */
public class Car_0Tile extends Tile {
	public Car_0Tile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid() {
		return true;
	}
}
