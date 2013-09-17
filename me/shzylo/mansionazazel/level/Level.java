package me.shzylo.mansionazazel.level;

import java.util.ArrayList;
import java.util.List;

import me.shzylo.mansionazazel.MansionAzazel;
import me.shzylo.mansionazazel.entity.Entity;
import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.level.tile.Tile;

/**
 * Abstract class for levels
 */
public class Level {
	public int width;
	public int height;
	protected int[] tilesInt;
	protected int[] tiles;
	private List<Entity> entities = new ArrayList<Entity>();

	public static Level spawn = new SpawnLevel("/levels/spawn.png");
	public static Level darkness = new SpawnLevel("/levels/darkness.png");

	/**
	 * Constructor to set the size
	 * 
	 * @param width
	 *           Width of the level
	 * @param height
	 *           Height of the level
	 */
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	/**
	 * Constructor to load the file
	 * 
	 * @param path
	 *           Path to the level
	 */
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	/**
	 * Generate the level
	 */
	protected void generateLevel() {
	}

	/**
	 * Load the level
	 * 
	 * @param path
	 *           Location of the level file
	 */
	protected void loadLevel(String path) {
	}
	
	/**
	 * Get the current level or map the player is in.
	 * @param game
	 */
	public String getLevel(MansionAzazel game) {
		if(game.level == spawn) {
			return "The Wreck";
		}
		return null;
	}

	/**
	 * Update the level
	 */
	public void update() {
		for(Entity e : entities) {
			e.update();
		}
	}

	/**
	 * Render the level
	 * 
	 * @param xScroll
	 *           The xOffset
	 * @param yScroll
	 *           The yOffset
	 * @param screen
	 *           The screen
	 */
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}

	/**
	 * Get the tile
	 * 
	 * @param x
	 *           The horizontal alignment
	 * @param y
	 *           The vertical alignment
	 * @return If the mob is solid or not
	 */
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.nothing;

		if (tiles[x + y * width] == Tile.grassColor) return Tile.grass;

		if (tiles[x + y * width] == Tile.treeTrunkColor) return Tile.treeTrunk;
		if (tiles[x + y * width] == Tile.treeTopColor) return Tile.treeTop;
		if (tiles[x + y * width] == Tile.treeTop_LColor) return Tile.treeTop_L;
		if (tiles[x + y * width] == Tile.treeTop_TColor) return Tile.treeTop_T;
		if (tiles[x + y * width] == Tile.treeTop_RColor) return Tile.treeTop_R;
		if (tiles[x + y * width] == Tile.treeTop_BColor) return Tile.treeTop_B;
		if (tiles[x + y * width] == Tile.treeTop_TLColor) return Tile.treeTop_TL;
		if (tiles[x + y * width] == Tile.treeTop_TRColor) return Tile.treeTop_TR;
		if (tiles[x + y * width] == Tile.treeTop_BLColor) return Tile.treeTop_BL;
		if (tiles[x + y * width] == Tile.treeTop_BRColor) return Tile.treeTop_BR;

		if (tiles[x + y * width] == Tile.roadColor) return Tile.road;
		if (tiles[x + y * width] == Tile.roadDashColor) return Tile.roadDash;
		if (tiles[x + y * width] == Tile.waterColor) return Tile.water;

		if (tiles[x + y * width] == Tile.dirtRoadColor) return Tile.dirtRoad;
		if (tiles[x + y * width] == Tile.dirtRoadDicipateLColor) return Tile.dirtRoadDicipateL;
		if (tiles[x + y * width] == Tile.dirtRoadDicipateRColor) return Tile.dirtRoadDicipateR;

		if (tiles[x + y * width] == Tile.cobbleColor) return Tile.cobble;
		if (tiles[x + y * width] == Tile.woodPegColor) return Tile.woodPeg;
		if (tiles[x + y * width] == Tile.woodColor) return Tile.wood;
		if (tiles[x + y * width] == Tile.woodLColor) return Tile.woodL;

		if (tiles[x + y * width] == Tile.boatColor) return Tile.boat;
		if (tiles[x + y * width] == Tile.boat_Color) return Tile.boat_;

		if (tiles[x + y * width] == Tile.car_0Color) return Tile.car_0;
		if (tiles[x + y * width] == Tile.car_1Color) return Tile.car_1;
		if (tiles[x + y * width] == Tile.car_2Color) return Tile.car_2;
		if (tiles[x + y * width] == Tile.car_3Color) return Tile.car_3;
		if (tiles[x + y * width] == Tile.car_4Color) return Tile.car_4;
		if (tiles[x + y * width] == Tile.car_5Color) return Tile.car_5;

		return Tile.nothing;
	}
	
	/**
	 * Add an entity to the list to get rendered.
	 * 
	 * @param ent
	 *            The entity
	 */
	public void addEntity(Entity ent) {
		this.entities.add(ent);
	}
}
