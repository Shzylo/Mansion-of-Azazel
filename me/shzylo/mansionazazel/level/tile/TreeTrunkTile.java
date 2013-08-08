package me.shzylo.mansionazazelvisual.level.tile;

import me.shzylo.mansionazazelvisual.gfx.Screen;
import me.shzylo.mansionazazelvisual.gfx.Sprite;

public class TreeTrunkTile extends Tile {

  public TreeTrunkTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid() {
		return true;
	}
}
