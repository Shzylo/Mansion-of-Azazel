package me.shzylo.mansionazazel.graphics;

/**
 * Factory for all Sprites
 */
public class Sprite {
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	public final int SIZE;

	public static Sprite nothing = new Sprite(16, 0x000000);
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite bush = new Sprite(16, 1, 0, SpriteSheet.tiles);
	
	public static Sprite treeTrunk = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf_L = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf_T = new Sprite(16, 4, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf_R = new Sprite(16, 5, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf_B = new Sprite(16, 6, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf = new Sprite(16, 7, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf_TL = new Sprite(16, 8, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf_TR = new Sprite(16, 9, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf_BL = new Sprite(16, 10, 0, SpriteSheet.tiles);
	public static Sprite treeLeaf_BR = new Sprite(16, 11, 0, SpriteSheet.tiles);
	
	public static Sprite road = new Sprite(16, 12, 0, SpriteSheet.tiles);
	public static Sprite roadDash = new Sprite(16, 13, 0, SpriteSheet.tiles);
	
	public static Sprite cobble = new Sprite(16, 14, 0, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 15, 0, SpriteSheet.tiles);
	
	public static Sprite dirtRoadDicipateL = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite dirtRoad = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite dirtRoadDicipateR = new Sprite(16, 2, 1, SpriteSheet.tiles);
	
	public static Sprite woodPeg = new Sprite(16, 3, 1, SpriteSheet.tiles);
	public static Sprite wood = new Sprite(16, 4, 1, SpriteSheet.tiles);
	public static Sprite woodL = new Sprite(16, 5, 1, SpriteSheet.tiles);

	public static Sprite boat = new Sprite(16, 6, 1, SpriteSheet.tiles);
	public static Sprite boat_ = new Sprite(16, 7, 1, SpriteSheet.tiles);

	public static Sprite car_0 = new Sprite(16, 12, 1, SpriteSheet.tiles);
	public static Sprite car_1 = new Sprite(16, 13, 1, SpriteSheet.tiles);
	public static Sprite car_2 = new Sprite(16, 12, 2, SpriteSheet.tiles);
	public static Sprite car_3 = new Sprite(16, 13, 2, SpriteSheet.tiles);
	public static Sprite car_4 = new Sprite(16, 12, 3, SpriteSheet.tiles);
	public static Sprite car_5 = new Sprite(16, 13, 3, SpriteSheet.tiles);

	public static Sprite playerF = new Sprite(32, 0, 0, SpriteSheet.player);
	public static Sprite playerF_1 = new Sprite(32, 0, 1, SpriteSheet.player);
	public static Sprite playerF_2 = new Sprite(32, 0, 2, SpriteSheet.player);

	public static Sprite playerS = new Sprite(32, 1, 0, SpriteSheet.player);
	public static Sprite playerS_1 = new Sprite(32, 1, 1, SpriteSheet.player);
	public static Sprite playerS_2 = new Sprite(32, 1, 2, SpriteSheet.player);

	public static Sprite playerB = new Sprite(32, 2, 0, SpriteSheet.player);
	public static Sprite playerB_1 = new Sprite(32, 2, 1, SpriteSheet.player);
	public static Sprite playerB_2 = new Sprite(32, 2, 2, SpriteSheet.player);
	
	public static Sprite ghost = new Sprite(32, 0, 0, SpriteSheet.ghost);

	/**
	 * Constructor for tiles that have a custom image
	 * @param size Size of the image
	 * @param x Horizontal location of the image
	 * @param y Vertical location of the image
	 * @param sheet SpriteSheet that this image is on
	 */
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	/**
	 * Constructor for tiles that are only one solid color
	 * @param size Size of the tile
	 * @param color Color of the tile
	 */
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	/**
	 * Set the color of a tile that has no image
	 * @param color Color of the tile
	 */
	public void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}

	/**
	 * Load the sprite
	 */
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
