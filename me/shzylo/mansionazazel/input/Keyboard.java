package me.shzylo.mansionazazelvisual.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

  private boolean[] keys = new boolean[120];
	public boolean up, down, left, right, debug;

	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];

		debug = keys[KeyEvent.VK_F1];
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 112) { // 112 = F1
			if (!debug) {
				keys[e.getKeyCode()] = true;
			} else {
				keys[e.getKeyCode()] = false;
			}
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
