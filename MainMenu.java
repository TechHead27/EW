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
    private GreenfootSound bgm;
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
        bgm = new GreenfootSound("BGM/TitleScreen.mp3");
        //bgm.playLoop();
        setBackground("images/menus/StartMenu.png");
    }
    
    public void act()
    {
        bgm.playLoop();
        if (Greenfoot.isKeyDown("enter"))
        {
            switch (selector.getSelection())
            {
                case 0: Greenfoot.setWorld(new ForestMap1());
                        bgm.stop();
                        break;
                case 1: Greenfoot.stop();
                        bgm.stop();
                        break;
            }
        }
        
        if (Greenfoot.isKeyDown("y"))
        {
            Greenfoot.setWorld(new Credits("images/credits/credits1.png"));
            bgm.stop();
        }
    }
}
