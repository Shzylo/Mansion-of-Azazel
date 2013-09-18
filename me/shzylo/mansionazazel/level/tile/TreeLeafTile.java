package me.shzylo.mansionazazel.level.tile;

import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.graphics.Sprite;

/**
 * Base leaf of a Tree<br><br>
 * <b>Solid Tile</b>
 */
public class TreeLeafTile extends Tile {
	public TreeLeafTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid() {
		return true;
	}
}
