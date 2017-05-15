
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
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Player playerRect = new Player();
        frame.add(playerRect);
        frame.addKeyListener(playerRect);
        frame.setVisible(true);
        Ball circle = new Ball();
        frame.add(circle);
        frame.setVisible(true);
        
        
        class TimerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                circle.checkBounds(frame.getHeight(), frame.getWidth());
                circle.moveBy(1,1);
            }
        }
        
        ActionListener listener = new TimerListener();
        Timer t = new Timer(1, listener);
        t.start();
    }
}
