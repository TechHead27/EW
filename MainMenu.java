import greenfoot.*;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    private static final int[][] options = {{170, 96}, {170, 200}, {170, 304}};
    private Arrow selector;
    private GreenfootSound bgm;
    
    private MenuItem play = new MenuItem("images/buttons/button_play.png");
    private MenuItem quit = new MenuItem("images/buttons/button_quit.png");;
    private MenuItem credits = new MenuItem("images/buttons/button_credits.png");;
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        selector = new Arrow(options);
        addObject(selector, 170, 96);
        addObject(play, 300, 90);
        addObject(quit, 300, 195);
        addObject(credits, 300, 300);
        
        bgm = new GreenfootSound("BGM/TitleScreen.mp3");
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
                case 2: Greenfoot.setWorld(new Credits("images/credits/credits1.png"));
                        bgm.stop();
                        break;
                default://never get here
                        break;
            }
        }
    }
}
