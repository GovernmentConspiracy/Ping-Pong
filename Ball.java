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
    private int x = 1;
    private int y = 101;
    private final int width = 27;
    private final int height = 27;
    private boolean right = true;
    private boolean up = true;
    
    public Ball()
    {
        rect = new Rectangle(x,y,width,height);
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
        repaint();
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
            return (int)rect.x + width;
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
            return (int)rect.y + height;
        }
    }
    
    public void checkBounds(int fHeight, int fWidth)
    {
        if (yCoord() + 27 >= fHeight || yCoord() == 0)
        {
            setUpBoolean();
        }
        if (xCoord() + 7 >= fWidth || xCoord() == 0)
        {
            setBoolean();
        }
    }
}