import greenfoot.*;

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-TILESIZE);
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+TILESIZE);
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-TILESIZE, getY());
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+TILESIZE, getY());
            Greenfoot.delay(MOVEDELAY);
        }
        
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new ForestBattle());
        }
    }
    
    public static final int TILESIZE = 1;
    public static final int MOVEDELAY = 16;
}
