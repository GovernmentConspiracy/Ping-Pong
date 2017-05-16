/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Opponent extends JComponent implements KeyListener
{
    private Rectangle oppRect;
    private int rectX = 500;
    private int rectY = 10;
    private int rectW = 10;
    private int rectH = 30;
    private int moveByY = 0;
    private int moveByX = 0;
    private int frameHeight;
    
    public Opponent()
    {
        oppRect = new Rectangle(rectX,rectY,rectW,rectH);
    }
    
    public int getRightX()
    {
        return rectX+rectW;
    }
    
    public int getTop()
    {
        return rectY;
    }
    
    public int getBot()
    {
        return rectY+rectH;
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.draw(oppRect);
    }

    public void moveByRect()
    {
        oppRect.translate(moveByX,moveByY);
        repaint();
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_UP)
        {
            moveByY = -10;        
            if(oppRect.y <= 0)
            {
                moveByY = 0;
            }
        }
        if(key == KeyEvent.VK_DOWN)
        {
            moveByY = 10;    
            if(oppRect.y >= 600) //max height of frame
            {
                moveByY = 0;
            }
        }
        moveByRect();
    }
    
    public void keyReleased(KeyEvent e)
    {
        moveByX = 0;
        moveByY = 0;
        moveByRect();
    }
    
    public void keyTyped(KeyEvent e)
    {
    }
}