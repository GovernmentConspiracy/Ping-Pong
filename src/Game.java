import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Game extends JComponent {
	public static void main(String args[]) {

		JFrame frame = new JFrame();

		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int padding = 50;
		Stage play = new Stage(frame.getWidth(), frame.getHeight(), 5, padding, 4, 3);
		frame.add(play);
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				play.align(frame.getWidth(), frame.getHeight(), padding);
			}
		});
		frame.addKeyListener(play);
		frame.setVisible(true);
		class BallBounce implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				play.bounceBall();
				play.accelerateBall(0, 4);
			}
		}
		Timer t1 = new Timer(1, new BallBounce());
		t1.start();
		class WallMove implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				play.movePaddles();
			}
		}
		Timer t2 = new Timer(1,  new WallMove());
		t2.start();

		Timer t3 = new Timer(1, null);

		class Scoring implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				int place = play.track();

				if (place != 0) {
					play.repaint();
					if (place < 0) {
						play.score1++;
						if (play.score1 >= 11) {
							t1.stop();
							t3.stop();
						}
					} else {
						play.score2++;
						if (play.score2 >= 11) {
							t1.stop();
							t3.stop();
						}
					}
					play.resetBall();
					play.repaint();

				}
			}
		}

		t3.addActionListener(new Scoring());
		t3.start();


	}
}
