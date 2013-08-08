package me.shzylo.mansionazazelvisual.level.tile;

import me.shzylo.mansionazazelvisual.gfx.Screen;
import me.shzylo.mansionazazelvisual.gfx.Sprite;

public class Car_5Tile extends Tile {

  public Car_5Tile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid() {
		return true;
	}
}
