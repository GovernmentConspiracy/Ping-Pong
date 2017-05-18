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
    private int midX;
    private final int width = 5;
    private final int height = 5;
    private boolean right = true;
    private boolean up = true;
    
    public Ball(int midX, int midY)
    {
        rect = new Rectangle(midX,midY,width,height);
    }
    
    public void setMid(int x)
    {
        midX = x/2;
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
   
    
    public int letsBounce(Control c, int fHeight, int fWidth)
    {
        int rheight = 0;
        int count = 0;
        if(rect.intersects(c.getRect()))
        {
            setBoolean();
        }
        else
        {
            if(yCoord() + 27 >= fHeight || yCoord() <= 0)
            {
                setUpBoolean();
            }
        }
        if (xCoord() <= 0)
        {
            return -1;
        }
        if (xCoord() >= fWidth)
        {
            return 1;
        }
        return 0;
    }
    
    public void reset(int frameX, int frameY)
    {
        rect.setLocation(frameX/2-5/2, frameY/2-5/2);
        repaint();
    }
}
