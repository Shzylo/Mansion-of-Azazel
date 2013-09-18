package me.shzylo.mansionazazel.entity;

import java.util.Random;

import me.shzylo.mansionazazel.graphics.Screen;
import me.shzylo.mansionazazel.level.Level;

/**
 * Abstract class for all entities
 */
public abstract class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	/**
	 * Update the entity
	 */
	public abstract void update();

	/**
	 * Render the entity to the screen
	 * 
	 * @param screen
	 *           The screen
	 */
	public abstract void render(Screen screen);

	/**
	 * Remove the entity from the level
	 */
	public void remove() {
		removed = true;
	}

	/**
	 * Check if the entity has been removed
	 * 
	 * @return if the entity is removed or not
	 */
	public boolean isRemoved() {
		return removed;
	}

	/**
	 * Put the entity into the level
	 * 
	 * @param level
	 *           The level the entity will be put into
	 */
	public final void init(Level level) {
		this.level = level;
	}
}
