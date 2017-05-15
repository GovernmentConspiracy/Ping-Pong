
/**
 * Write a description of class BallBeta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BallBeta
{
    private Rectangle ball;
    private double[] vector;
    public BallBeta(int frameX, int frameY, boolean left, double mag)
    {
        double angle = Math.random()*2*Math.PI;
        ball = new Rectangle(frameX-5/2, frameY-5/2, 5, 5);
        vector = new double[] {mag*Math.cos(angle), mag*Math.sin(angle)};
    }
    
    public boolean ifCollide(Paddle wall)
    {
        //if (
        return ball.intersects(wall.getWall());
    }
    
    /**
     * Changes ball's speed to mag and keeps angle 
     */
    public void accelerate(double mag)
    {
        double speed = getSpeed();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i]*mag/speed;
        }
    }
    
    /**
     * Returns speed
     */
    public double getSpeed()
    {
        double mag = 0;
        for (int i = 0; i < vector.length; i++) {
            mag += Math.pow(vector[i], 2);
        }
        return Math.pow(mag, .5);
    }
    
    /**
     * 
     */
    public void setVector(double[] part){
        vector = part;
    }
    
    public double[] reflect(double[] mirror)
    {
        double[] part = new double[2];
        for (int i = 0; i < part.length; i++) {
            part[i] = vector[i]*mirror[i];
        }
        return part;
    }
    
    public void cruise()
    {
        ball.translate((int)vector[0], (int)vector[1]);
    }
}
