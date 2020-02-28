import java.awt.*;

public class Ball {
	private Rectangle ball;
	private double[] vector;
	private int diameter;
	private double speed;

	public Ball(int top, int bottom, int left, int right, int diameter, double speed) {
		this.diameter = diameter;
		ball = new Rectangle();
		vector = new double[2];
		resetBall(top, bottom, left, right, speed);
	}

	public Rectangle getRectangle() {
		return ball;
	}

	public int getDiameter() {
		return diameter;
	}

	public void resetBall(int top, int bottom, int left, int right, double speed) {
		resetPosition(top, bottom, left, right);
		resetVector(speed, randomAngle());
	}

	private void resetPosition(int top, int bottom, int left, int right) {
		double percentage = .05;
		ball.setBounds(center(left, right, diameter) + randomOffset(left, right, percentage),
				center(top, bottom, diameter) + randomOffset(top, bottom, percentage),
				diameter,
				diameter);
	}

	private static int center(int size, int lower, int upper) {
		return (lower + upper - size) / 2;
	}

	private static int randomOffset(int lower, int upper, double percentage) {
		double variation = percentage * Math.abs(upper - lower);
		return (int) ((Math.random() * variation) - variation);
	}

	private static double randomAngle() {
		return Math.toRadians((Math.random() * 30 + 30)
				+ 45 + 45 * randomSign()) *
				randomSign();
	}

	private static int randomSign() {
		if (Math.random() < .5) {
			return -1;
		}
		return 1;
	}

	private void resetVector(double speed, double radians) {
		this.speed = speed;
		vector[0] = speed * Math.cos(radians);
		vector[1] = speed * Math.sin(radians);
	}

	public boolean isCollide(Rectangle wall) {
		return ball.intersects(wall);
	}

	public void accelerate(double newSpeed) {
		for (int i = 0; i < vector.length; i++) {
			vector[i] *= newSpeed/speed;
		}
		speed = newSpeed;
	}

	public double getSpeed() {
		return speed;
	}

	public void reflect(double... mirror) {
		for (int i = 0; i < vector.length; i++) {
			vector[i] *= mirror[i];
		}
	}

	public void cruise() {
		ball.translate((int) vector[0], (int) vector[1]);
	}
}
