package me.shzylo.mansionazazelvisual;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.UIManager;

import me.shzylo.mansionazazelvisual.entity.mob.Player;
import me.shzylo.mansionazazelvisual.gfx.Screen;
import me.shzylo.mansionazazelvisual.input.Keyboard;
import me.shzylo.mansionazazelvisual.input.StartMenuKeys;
import me.shzylo.mansionazazelvisual.level.Level;
import me.shzylo.mansionazazelvisual.level.TileCoordinate;

public class MansionAzazelVisual extends Canvas implements Runnable {
  private static final long serialVersionUID = 1L;

	public static int playerHealth = 10;

	private static int width = 160;
	private static int height = 160;
	private static int scale = 3;
	private static String title = "Mansion of Azazel";

	private static String debugInfoFrames = "Frames: 0";
	private static String debugInfoUpdates = "Updates: 0";

	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private StartMenuKeys smk;
	private Level level;
	private Player player;

	private boolean running = false;
	public static boolean startedGame = false;

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	public MansionAzazelVisual() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		smk = new StartMenuKeys();
		level = Level.spawn;
		TileCoordinate playerSpawn = new TileCoordinate(54, 52);
		player = new Player(playerSpawn.x(), playerSpawn.y(), key);
		player.init(level);

		addKeyListener(key);
		addKeyListener(smk);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Mansion of Azazel_VISUAL");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000d / 60d;
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
				debugInfoFrames = ("Frames: " + frames);
				debugInfoUpdates = ("Updates: " + updates);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update() {
		if(startedGame) {
			key.update();
			player.update();
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();

		final Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		Font font = new Font(null, 0, 16);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Health: " + playerHealth, 5, getHeight() - 10);

		if (startedGame) {
			int xScroll = player.x - screen.width / 2;
			int yScroll = player.y - screen.height / 2;
			level.render(xScroll, yScroll, screen);
			player.render(screen);

			for (int i = 0; i < pixels.length; i++) {
				pixels[i] = screen.pixels[i];
			}

			if (key.debug) {
				g.setColor(Color.WHITE);
				g.setFont(font);
				g.drawString("DEBUG INFO", 5, 15);
				font = new Font("Courier New", 0, 16);
				g.setFont(font);
				g.drawString(debugInfoFrames, 5, 35);
				g.drawString(debugInfoUpdates, 5, 55);
			}
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
			font = new Font("Trebuchet MS", 1, 28);
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("M a n s i o n     o f     A z a z e l", getWidth() / 10, getHeight() / 4);
			font = new Font("Courier New", 0, 16);
			g.setFont(font);
			g.setColor(Color.YELLOW);
			g.drawString("Press 'Enter' to start a new game", getWidth() / 6, getHeight() / 3 + 20);
			g.drawString("Press 'Space' to load a previous game", getWidth() / 9 + 5, getHeight() / 3 + 50);
			g.drawString("Press 'C' to see the credits", getWidth() / 5 + 5, getHeight() / 2);
			g.drawString("Press 'H' to see the help menu", getWidth() / 5 - 5, getHeight() / 9 * 5 + 5);
			g.drawString("Press 'Q' to quit.", getWidth() / 3 - 10, getHeight() / 4 * 3);
		}

		g.dispose();
		bs.show();
	}
	
	private static void setLookAndFeel() throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}

	public static void main(String[] args) {
		MansionAzazelVisual game = new MansionAzazelVisual();

		String iconPath = "/icon/icon.png";
		InputStream iconStream = MansionAzazelVisual.class.getResourceAsStream(iconPath);
		BufferedImage icon;
		try {
			icon = ImageIO.read(iconStream);
			game.frame.setIconImage(icon);
		} catch (IOException e) {
			e.printStackTrace();
		}

		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		try {
			setLookAndFeel();
		} catch (Exception e) {
			e.printStackTrace();
		}

		game.start();
	}
}
