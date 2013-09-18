package me.shzylo.mansionazazel.graphics;

import java.util.Random;

import me.shzylo.mansionazazel.level.tile.Tile;

/**
 * Represents the screen
 */
public class Screen {
	public int height, width;
	public int[] pixels;

	public final int MAP_SIZE = 2;

	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	public int xOffset, yOffset;
	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	/**
	 * Clear the screen so there are no duplicated pixels
	 */
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	// public void render() {
	// for (int y = 0; y < height; y++) {
	// for(int x = 0; x < width; x++) {
	// pixels[50 + 30 * width] = 0xff00ff;
	// }
	// }
	// }

	/**
	 * Renders a tile onto the screen
	 * 
	 * @param xp
	 *           Horizontal axis for the image
	 * @param yp
	 *           Vertical axis for the image
	 * @param tile
	 *           The tile
	 */
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	/**
	 * Renders the player onto the screen
	 * 
	 * @param xp
	 *           Horizontal axis for the image
	 * @param yp
	 *           Vertical axis for the image
	 * @param sprite
	 *           The sprite of the player
	 * @param flip
	 *           How the image should be scewed
	 */
	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3) {
				ys = 31 - y;
			}
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				int xs = x;
				if (flip == 1 || flip == 3) {
					xs = 31 - x;
				}
				if (xa < -16 || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.pixels[xs + ys * 32];
				if (col != 0xffff00ff)
					pixels[xa + ya * width] = col;
			}
		}
	}

	/**
	 * Renders the ghost onto the screen
	 * 
	 * @param xp
	 *           Horizontal axis of the image
	 * @param yp
	 *           Vertical axis of the image
	 * @param sprite
	 *           The sprite of the ghost
	 * @param flip
	 *          How the image should be skewed
	 */
	public void renderGhost(int xp, int yp, Sprite sprite, int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3) {
				ys = 31 - y;
			}

			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				int xs = x;

				if (flip == 1 || flip == 3) {
					xs = 31 - x;
				}

				if (xa < -16 || xa >= width || ya < 0 || ya >= height)
					break;

				if (xa < 0)
					xa = 0;

				int col = sprite.pixels[xs + ys * 32];
				if (col != 0xFFFF00FF)
					pixels[xa + ya * width] = col;
			}
		}
	}

	/**
	 * Sets the offset
	 * 
	 * @param xOffset
	 *           Horizontal offset
	 * @param yOffset
	 *           Vertical offset
	 */
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
