package me.shzylo.mansionazazel.level;

/**
 * Tiles in the form of coordinates
 */
public class TileCoordinate {
	private int x, y;
	private final int TILE_SIZE = 16;

	public TileCoordinate(int x, int y) {
		this.x = x * TILE_SIZE;
		this.y = y * TILE_SIZE;
	}

	/**
	 * Gets the TileCoordinate at x
	 * 
	 * @return X
	 */
	public int x() {
		return x;
	}

	/**
	 * Gets the TileCoordinate at y
	 * 
	 * @return Y
	 */
	public int y() {
		return y;
	}

	/**
	 * Returns both x and y
	 * 
	 * @return X, Y
	 */
	public int[] xy() {
		int[] r = new int[2];
		r[0] = x;
		r[1] = y;
		return r;
	}

	/**
	 * Retrieves the distance, converts into tile distance.
	 * 
	 * @param tileDist The factor of the given distance times TILE_SIZE (16)
	 * @return The tile distance
	 */
	public int dist(int tileDist) {
		return tileDist * TILE_SIZE;
	}
}
