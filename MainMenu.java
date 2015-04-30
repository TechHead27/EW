import greenfoot.*;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    private final int[][] options = {{150, 120}, {150, 250}};
    private Arrow selector;
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        selector = new Arrow(options);
        addObject(selector, 150, 120);
        setBackground("images/menus/StartMenu.png");
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            switch (selector.getSelection())
            {
                case 0: Greenfoot.setWorld(new ForestMap1());
                        break;
                case 1: Greenfoot.stop();
                        break;
            }
        }
        
        if (Greenfoot.isKeyDown("y"))
        {
            Greenfoot.setWorld(new Credits("credits1.png"));
        }
    }
}
