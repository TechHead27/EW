import greenfoot.*;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    public HealthBar()
    {
        super();
        GreenfootImage bar = new GreenfootImage("images/hpbar/hp_100%.png");
        bar.scale(150, 40);
        setImage(bar);
    }
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
