package me.shzylo.mansionazazel.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The user's input for the character.
 */
public class Keyboard implements KeyListener {
	public boolean[] keys = new boolean[120];
	public boolean up, down, left, right, debug;

	/**
	 * Update the keys
	 */
	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
		debug = keys[KeyEvent.VK_F1];
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 112) {
			if (!debug)
				keys[e.getKeyCode()] = true;
			else
				keys[e.getKeyCode()] = false;
		} else {
			if (e.getKeyCode() < keys.length) {
				keys[e.getKeyCode()] = true;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if ((!(e.getKeyCode() == 112)) && e.getKeyCode() < keys.length) {
			keys[e.getKeyCode()] = false;
		}
	}

	public void keyTyped(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

}
