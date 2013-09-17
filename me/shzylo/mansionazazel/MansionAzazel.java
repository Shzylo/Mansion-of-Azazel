package me.shzylo.mansionazazel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import me.shzylo.mansionazazel.entity.mob.Ghost;
import me.shzylo.mansionazazel.entity.mob.Player;
import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.input.Keyboard;
import me.shzylo.mansionazazel.level.Level;
import me.shzylo.mansionazazel.level.TileCoordinate;

/**
 * Main class for Mansion of Azazel
 */
public final class MansionAzazel extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private final int WIDTH = 160;
	private final int HEIGHT = 160;
	private final int SCALE = 3;
	private final double UPDATE_RATE = 60;

	private String debugFPS = "Frames: 0";
	private String debugUPS = "Updates: 0";

	public JFrame frame;
	public Level level;
	private Thread thread;
	private Screen screen;
	private Keyboard key;
	private Player player;
	private Ghost ghost;

	private boolean running = false;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	/**
	 * Main constructor
	 */
	public MansionAzazel() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		screen = new Screen(WIDTH, HEIGHT);
		frame = new JFrame();
		key = new Keyboard();
		level = Level.spawn;
		TileCoordinate ghostSpawn = new TileCoordinate(52, 50);
		TileCoordinate playerSpawn = new TileCoordinate(54, 52);
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		player.init(level);
		ghost = new Ghost(ghostSpawn.x(), ghostSpawn.y(), player);
		ghost.init(level);

		level.addEntity(player);
		level.addEntity(ghost);

		addKeyListener(key);
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000d / UPDATE_RATE;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				debugFPS = "Frames: " + frames;
				debugUPS = "Updates: " + updates;
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	/**
	 * Start the game
	 */
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Mansion of Azazel");
		thread.start();
	}

	/**
	 * Stop the game
	 */
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update the game
	 */
	public void update() {
		key.update();
		level.update();
	}

	/**
	 * Render the game
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		// screen.render();

		int yScroll = player.y - (screen.height / 2);
		int xScroll = player.x - (screen.width / 2);

		level.render(xScroll, yScroll, screen);
		ghost.render(screen);
		player.render(screen);

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		{
			Font font = new Font("Courier New", 0, 18);
			if (key.debug) {
				g.setColor(Color.white);
				g.setFont(font);
				g.drawString("______________", 2, 4);
				g.drawString(debugFPS, 2, 32);
				g.drawString(debugUPS, 2, 46);
				g.drawString("X: " + player.getX() / 16, 2, 60);
				g.drawString("Y: " + player.getY() / 16, 2, 74);
				g.drawString("Map: " + level.getLevel(this), 2, 88);
				g.drawString("______________", 2, 94);
			}
		}

		g.dispose();
		bs.show();
	}
	
	/**
	 * Set the icon of the frame
	 * @param frame The Window (JFrame)
	 */
	public static void setIcon(JFrame frame) {
		try {
			URL iconPath = MansionAzazel.class.getResource("/icons/icon.png");
			ImageIcon icon = new ImageIcon(iconPath);
			frame.setIconImage(icon.getImage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads up the game
	 */
	public static void main(String[] args) {
		MansionAzazel game = new MansionAzazel();

		setIcon(game.frame);
		game.frame.setTitle("Mansion of Azazel");
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
