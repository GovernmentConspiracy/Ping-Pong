/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ball extends JComponent
{
    private Rectangle rect;
    private boolean right = true;
    private boolean up = true;
    
    
    public Ball()
    {
        rect = new Rectangle(4,5,5,5);
    }
    
    public void paintComponent (Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(rect);
    }
    
    public void moveBy (int xx, int yy)
    {
        if (right == false)
        {
            xx = -xx;
        }
        if (up == true)
        {
            yy = -yy;
        }
        rect.translate(xx,yy);
        repaint(); //recalls the paintComponent method
    }
    
    public void setBoolean()
    {
        right = !right;
    }
    
    public void setUpBoolean()
    {
        up = !up;
    }
    
    public int xCoord()
    {
        if (right)
        {
            return (int)rect.x + rect.width;
        }
        else
        {
            return (int)rect.x;
        }
    }
    
    public int yCoord()
    {
        if (up)
        {
            return (int)rect.y;
        }
        else
        {
            return (int)rect.y + rect.height;
        }
    }
    
    public void checkBounds(int w, int h)
    {
        if (yCoord() >= h || yCoord() <= 0)
        {
            setUpBoolean();
        }
        if (xCoord() >= w || xCoord() <= 0)
        {
            setBoolean();
        }
    }
    
    /**
     * This should be in a different class, so that everything can be added.
     */
    public static void main (String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ball rect = new Ball();
        frame.add(rect);
        frame.setVisible(true);
        //System.out.print(frame.WIDTH);
        class TimerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                rect.checkBounds(frame.getWidth(), frame.getHeight());
                rect.moveBy(4,2);
            }
        }
        
        ActionListener listener = new TimerListener();
        Timer t = new Timer(1, listener); //delays by some milliseconds
        t.start();
    }
}
