import greenfoot.*;

/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slime extends Monster
{
    public Slime()
    {
        super();
        GreenfootImage slime = getImage();
        slime.scale(120, 120);
        setImage(slime);
    }
    
    /**
     * Act - do whatever the Slime wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
