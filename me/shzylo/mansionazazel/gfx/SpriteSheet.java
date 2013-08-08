package me.shzylo.mansionazazelvisual.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

  private String path;
	public final int SIZE;
	public int[] pixels;

	public static SpriteSheet tiles = new SpriteSheet("/sheets/tiles.png", 256);
	public static SpriteSheet player = new SpriteSheet("/sheets/player.png", 96);

	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			pixels = image.getRGB(0, 0, w, h, null, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
