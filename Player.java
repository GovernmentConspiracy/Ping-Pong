/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Player extends JComponent implements KeyListener
{
    private Rectangle playerRect;
    private int rectX = 10;
    private int rectY = 10;
    private int rectW = 10;
    private int rectH = 30;
    private int moveByY = 0;
    private int moveByX = 0;
    private int frameHeight;
    
    public Player()
    {
        playerRect = new Rectangle(rectX,rectY,rectW,rectH);
    }
    
    public int getLeftX()
    {
        return rectX;
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
        g2.draw(playerRect);
    }

    public void moveByRect()
    {
        playerRect.translate(moveByX,moveByY);
        repaint();
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_W)
        {
            moveByY = -10;        
            if(playerRect.y <= 0)
            {
                moveByY = 0;
            }
        }
        if(key == KeyEvent.VK_S)
        {
            moveByY = 10;    
            if(playerRect.y >= 600) //max height of frame
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