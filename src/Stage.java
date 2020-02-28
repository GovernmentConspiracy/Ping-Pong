import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Stage extends JComponent implements KeyListener {
	private Ball ball;
	private Paddle[] paddles;
	private Rectangle background;
	private Rectangle[] walls;
	private int top, bottom, left, right;
	private double startingBallSpeed;
	private double paddleSpeed;
	public int score1, score2;
	private int padding;

	public Stage(int width, int height, int ballDiameter, int padding, double startingBallSpeed, double paddleSpeed) {
		score1 = score2 = 0;
		paddles = new Paddle[2];
		walls = new Rectangle[4];
		align(width, height, padding);

		this.startingBallSpeed = startingBallSpeed;
		ball = new Ball(top, bottom, left, right, ballDiameter, startingBallSpeed);

		background = new Rectangle(0, 0, width, height);
		this.paddleSpeed = paddleSpeed;

	}

	/**
	 * Moves paddles around.
	 */
	public void movePaddles() {
		for (Paddle paddle: paddles) {
			paddle.move(top, bottom, left, right, (int) paddleSpeed);
		}
		repaint();
	}

	public void accelerateBall(double deltaMag, double lim) {
		double increasedSpeed = ball.getSpeed() + deltaMag;
		if (increasedSpeed > lim)
			increasedSpeed = lim;
		ball.accelerate(increasedSpeed);
	}

	public int track() {
		int x = ball.getRectangle().x;
		if (x <= left)
			return 1;
		if (x >= right)
			return -1;
		return 0;
	}

	public void bounceBall() {
		ball.cruise();
		Rectangle stats = ball.getRectangle();
		if (stats.y <= top ||
				stats.y + stats.height >= bottom) {
			ball.reflect(1, -1);
		}

		for (Paddle a : paddles) {
			if (ball.isCollide(a.getWall())) {
				ball.reflect(-1, 1);
			}
		}
	}

	public void align(int width, int height, int padding) {
		this.padding = padding;
		top = padding * 2;
		bottom = height - padding;
		left = padding;
		right = width - padding;

		walls[0] = new Rectangle(0, top - padding, width, padding);
		walls[1] = new Rectangle(0, bottom, width, padding);
		walls[2] = new Rectangle(left - padding, top, padding, height);
		walls[3] = new Rectangle(right, top, padding, height);

		paddles[0] = new Paddle(-1, top, bottom, left, right);
		paddles[1] = new Paddle(1, top, bottom, left, right);

		background = new Rectangle(0, 0, width, height);
		movePaddles();
		repaint();
	}

	public void resetBall() {
		ball.resetBall(top, bottom, left, right, startingBallSpeed);
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				paddles[0].setDirection(-1);
				break;
			case KeyEvent.VK_S:
				paddles[0].setDirection(1);
				break;
			case KeyEvent.VK_UP:
				paddles[1].setDirection(-1);
				break;
			case KeyEvent.VK_DOWN:
				paddles[1].setDirection(1);
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
			case KeyEvent.VK_S:
				paddles[0].setDirection(0);
				break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				paddles[1].setDirection(0);
				break;
		}
	}

	public void keyTyped(KeyEvent e) {
		//no functions
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.fill(background);
		g2.setColor(Color.white);
		g2.fill(ball.getRectangle());
		for (Paddle a : paddles) {
			g2.fill(a.getWall());
		}
		for (Rectangle a : walls) {
			g2.fill(a);
		}
		g2.drawString("P1: " + score1, left + 35, top - padding);
		g2.drawString("P2: " + score2, right - 55, top - padding);
	}

}

