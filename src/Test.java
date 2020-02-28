
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    /**
     * Angle Test Fire in Degrees
     * Goal: [30,60] U 
     */
    public static void main(String[] args)
    {
        for (int i = 1; i <= 100; i++)
            System.out.println(((Math.random()*30+30))
            + 45 + 45*Math.pow(-1,(int)(Math.random()*2))
            //*Math.pow(-1,(int)(Math.random()*2))
            );
    }
}
