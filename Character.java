import greenfoot.*;

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    private boolean moved;
    
    public Character()
    {
        moved = false;
    }
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-TILESIZE);
            moved = true;
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+TILESIZE);
            moved = true;
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-TILESIZE, getY());
            moved = true;
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+TILESIZE, getY());
            moved = true;
            Greenfoot.delay(MOVEDELAY);
        }
        
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new ForestBattle());
        }
    }
    
    public boolean hasMoved()
    {
        boolean ret = moved;
        moved = false;
        return ret;
    }
    
    public static final int TILESIZE = 1;
    public static final int MOVEDELAY = 16;
}
