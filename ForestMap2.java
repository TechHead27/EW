import greenfoot.*;

/**
 * Write a description of class ForestMap2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestMap2 extends World
{
    private Character player;
    private java.util.Random gen;
    private GreenfootSound bgm;
    private GreenfootImage background = new GreenfootImage("images/map/scene2.png");
    /**
     * Constructor for objects of class ForestMap2.
     * 
     */
    public ForestMap2()
    {    
        // Create a new world with 12x8 cells with a cell size of 50x50 pixels.
        super(12, 8, 50); 
        background.scale(678, 432);
        player = new Character(11, 7);
        addObject(player, 0, 0);
        Greenfoot.delay(15);
        gen = new java.util.Random();
        bgm = new GreenfootSound("BGM/Mansion1.mp3");
        bgm.playLoop();
        //setBackground("images/map/tree.png");
        setBackground(background);
    }
    
    public ForestMap2(Character c)
    {
        // Create a new world with 12x8 cells with a cell size of 50x50 pixels.
        super(12, 8, 50);
        player = c;
        player.setMovable(true);
        player.exploreReady();
        addObject(player, 0,0);
        //Greenfoot.delay(15); Seems unnecessary? Not exactly sure what it was for
        gen = new java.util.Random();
        bgm = new GreenfootSound("BGM/Mansion1.mp3");
        bgm.playLoop();
        setBackground("images/map/tree.png");
    }
    
    public void act()
    {
        if (player.hasMoved() && gen.nextFloat() <= 0.20)
        {
            Greenfoot.delay(7);
            Greenfoot.setWorld(new MansionBattle(player, Greenfoot.getRandomNumber(4)));
            bgm.stop();
            //Greenfoot.delay(5);
        }
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new MansionBattle(player, 3));
            bgm.stop();
        }
        else if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(new MainMenu());
            bgm.stop();
        }
    }
}
