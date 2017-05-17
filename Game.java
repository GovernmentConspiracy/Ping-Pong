
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Game extends JComponent
{
    public static void main (String args[])
    {
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Player playerRect = new Player(frame.getWidth() - 50, frame.getHeight()/2);
        frame.add(playerRect);
        frame.addKeyListener(playerRect);
        frame.setVisible(true);
        Opponent oppRect = new Opponent(50, frame.getHeight()/2);
        frame.add(oppRect);
        frame.addKeyListener(oppRect);
        frame.setVisible(true);
        Ball circle = new Ball(frame.getWidth()/2, frame.getHeight()/2);
        frame.add(circle);
        frame.setVisible(true);
        
        
        class TimerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                circle.setMid(frame.getHeight());
                circle.letsBounce(oppRect, frame.getHeight(),frame.getWidth());
                circle.letsBounce(playerRect, frame.getHeight(),frame.getWidth());
                circle.moveBy(1,1);
            }
        }
        
        ActionListener listener = new TimerListener();
        Timer t = new Timer(4, listener);
        t.start();
    }
}
