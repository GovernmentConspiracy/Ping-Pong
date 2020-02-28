
/**
 * Write a description of class Paddle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.*;

public class Paddle {
	private int direction;
	private Rectangle wall;
	int spacing;
	int type;

	public Paddle(int side, int top, int bottom, int left, int right) {
		type = side;
		spacing = 30;
		int width = 80 / 20;
		int height = 80;
		if (side < 0) {
			wall = new Rectangle(left + spacing, (top + bottom - height) / 2, width, height);
		} else {
			wall = new Rectangle(right - spacing - width, (top + bottom - height) / 2, width, height);
		}
		direction = 0;
	}

	public Rectangle getWall() {
		return wall;
	}

	public void setDirection(int way) {
		direction = way;
	}

	public void move(int top, int bottom, int left, int right, int paddleSpeed) {
		wall.translate(0, direction * paddleSpeed);
		if (wall.y < top) {
			if (type < 0)
				wall.setLocation(left + spacing, top);
			else
				wall.setLocation(right - spacing - wall.width, top);
		}
		if (wall.y + wall.height > bottom) {
			if (type < 0)
				wall.setLocation(left + spacing, bottom - wall.height);
			else
				wall.setLocation(right - spacing - wall.width, bottom - wall.height);
		}
	}
}
