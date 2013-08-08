package me.shzylo.mansionazazelvisual.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import me.shzylo.mansionazazelvisual.MansionAzazelVisual;

public class StartMenuKeys implements KeyListener {

  public void keyPressed(KeyEvent e) {
		
		if (!MansionAzazelVisual.startedGame) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				MansionAzazelVisual.startedGame = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				// Finish Later
			}

			if (e.getKeyCode() == KeyEvent.VK_C) {
				String message = "<HTML><U>Code</U></HTML>\nShzylo\n\n" +
						"<HTML><U>Art</U></HTML>\nShzylo\n Brandon Ecroso\n\n" +
						"<HTML><U>Inspirations</U></HTML>\nEcroso Games\nPaul Speed\n\n" +
						"<HTML><U>Special Thanks</U></HTML>\nMythruna Community\nAll Supporters\n\n";
				JOptionPane.showMessageDialog(null, message, "Credits", JOptionPane.PLAIN_MESSAGE);
			}

			if (e.getKeyCode() == KeyEvent.VK_H) {
				String message = "<HTML><U>Story Line</U></HTML>\nYou awake in a car, realizing that you have been in a wreck.\n" +
						"You have hit a tree, but why were you in the wreck?\n\n" +
						"<HTML><U>The Goal</U></HTML>\n" +
						"While in the search for shelter, you spot a mansion nearby.\n" +
						"Later, you find the mansion is not what it seems.\n" +
						"Your goal is to defeat the evil inside and escape!\n\n" +
						"<HTML><U>Controls</U></HTML>\nWASD/Arrow Keys - Walk\n" +
						"F1 - Debug Menu\n" +
						"Backspace - Save\n" +
						"Q - Saves and quits the game.\n";
				JOptionPane.showMessageDialog(null, message, "Help", JOptionPane.PLAIN_MESSAGE);
			}

			if (e.getKeyCode() == KeyEvent.VK_Q) {
				System.exit(0);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}
