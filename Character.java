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
    private int x;
    private int y;
    
    public Character(int startx, int starty)
    {
        moved = false;
        GreenfootImage player = new GreenfootImage("images/priest/priest_victory1.png");
        player.scale(70, 70);
        setImage(player);
        x = startx;
        y = starty;
    }
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up"))
        {
            y -= TILESIZE;
            moved = true;
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            y += TILESIZE;
            moved = true;
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            x -= TILESIZE;
            moved = true;
            Greenfoot.delay(MOVEDELAY);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            x += TILESIZE;
            moved = true;
            Greenfoot.delay(MOVEDELAY);
        }
        
        setLocation(x, y);
    }
    
    public boolean hasMoved()
    {
        boolean ret = moved;
        moved = false;
        return ret;
    }
    
    public static final int TILESIZE = 1;
    public static final int MOVEDELAY = 12;
}
