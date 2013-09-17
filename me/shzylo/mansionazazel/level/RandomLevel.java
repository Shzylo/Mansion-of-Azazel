package me.shzylo.mansionazazel.level;

import java.util.Random;

/**
 * A randomly generated level
 */
public class RandomLevel extends Level {
	public static final Random random = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	@Override
	protected void generateLevel() {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x + y * width] = random.nextInt(4);
			}
		}
	}
}
