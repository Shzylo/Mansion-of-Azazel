package me.shzylo.mansionazazelvisual.entity.mob;

import me.shzylo.mansionazazelvisual.gfx.Screen;
import me.shzylo.mansionazazelvisual.gfx.Sprite;
import me.shzylo.mansionazazelvisual.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.playerF;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (anim < 1000000)
			anim++;
		else
			anim = 0;

		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) {
			sprite = Sprite.playerF;
			if (walking) {
				if (anim % 60 >= 45) {
					sprite = Sprite.playerF;
				} else if (anim % 60 >= 30) {
					sprite = Sprite.playerF_2;
				} else if (anim % 60 >= 15) {
					sprite = Sprite.playerF;
				} else {
					sprite = Sprite.playerF_1;
				}
			}
		}

		if (dir == 1) {
			sprite = Sprite.playerS;
			if (walking) {
				if (anim % 60 >= 45) {
					sprite = Sprite.playerS;
				} else if (anim % 60 >= 30) {
					sprite = Sprite.playerS_2;
				} else if (anim % 60 >= 15) {
					sprite = Sprite.playerS;
				} else {
					sprite = Sprite.playerS_1;
				}
			}
		}

		if (dir == 2) {
			sprite = Sprite.playerB;
			if (walking) {
				if (anim % 60 >= 45) {
					sprite = Sprite.playerB;
				} else if (anim % 60 >= 30) {
					sprite = Sprite.playerB_2;
				} else if (anim % 60 >= 15) {
					sprite = Sprite.playerB;
				} else {
					sprite = Sprite.playerB_1;
				}
			}
		}

		if (dir == 3) {
			sprite = Sprite.playerS;
			flip = 1;
			if (walking) {
				if (anim % 60 >= 45) {
					sprite = Sprite.playerS;
				} else if (anim % 60 >= 30) {
					sprite = Sprite.playerS_2;
				} else if (anim % 60 >= 15) {
					sprite = Sprite.playerS;
				} else {
					sprite = Sprite.playerS_1;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
