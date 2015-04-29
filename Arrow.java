import greenfoot.*;

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    private final int[][] options;
    private int selection;
    
    public Arrow(int[][] menu)
    {
        GreenfootImage cross = new GreenfootImage("images/buttons/Cross.png");
        cross.scale(67, 64);
        setImage(cross);
        options = menu;
        selection = 0;
        setLocation(options[selection][0], options[selection][1]);
    }
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("right"))
        {
            selection = (selection + 1) % options.length;
            setLocation(options[selection][0], options[selection][1]);
            Greenfoot.delay(DELAY);
        }
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("left"))
        {
            selection = selection==0?options.length - 1:selection - 1;
            setLocation(options[selection][0], options[selection][1]);
            Greenfoot.delay(DELAY);
        }
    }
    
    public int getSelection()
    {
        return selection;
    }
    
    private static final int DELAY = 12;
}
