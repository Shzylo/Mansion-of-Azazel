package me.shzylo.mansionazazel.level.tile;

import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.graphics.Sprite;

/**
 * The transaction from the paved-road turning into dirt road on the right side<br><br>
 * <b>Solid Tile</b>
 */
public class DirtRoadDicipateRTile extends Tile {
	public DirtRoadDicipateRTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid() {
		return true;
	}
}
