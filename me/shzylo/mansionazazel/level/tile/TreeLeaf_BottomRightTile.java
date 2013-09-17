package me.shzylo.mansionazazel.level.tile;

import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.graphics.Sprite;

/**
 * The bottom-right leafs of a tree<br><br>
 * <b>Solid Tile</b>
 */
public class TreeLeaf_BottomRightTile extends Tile {
	public TreeLeaf_BottomRightTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid() {
		return true;
	}
}
