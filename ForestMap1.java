import greenfoot.*;

/**
 * Write a description of class ForestMap1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestMap1 extends World
{

    private Character player;
    private java.util.Random gen;
    private GreenfootSound bgm;
    /**
     * Constructor for objects of class ForestMap1.
     * 
     */
    public ForestMap1()
    {
        // Create a new world with 12x8 cells with a cell size of 50x50 pixels.
        super(12, 8, 50);
        player = new Character(11, 7);
        addObject(player, 11, 7);
        Greenfoot.delay(15);
        gen = new java.util.Random();
        bgm = new GreenfootSound("BGM/Forest1.mp3");
        bgm.playLoop();
        setBackground("images/map/tombstone.png");
    }
    
    public ForestMap1(Character c)
    {
        // Create a new world with 12x8 cells with a cell size of 50x50 pixels.
        super(12, 8, 50);
        player = c;
        player.setMovable(true);
        player.exploreReady();
        addObject(player, 300, 200);
        //Greenfoot.delay(15); Seems unnecessary? Not exactly sure what it was for
        gen = new java.util.Random();
        bgm = new GreenfootSound("BGM/Forest1.mp3");
        bgm.playLoop();
        setBackground("images/map/tombstone.png");
    }
    
    public void act()
    {
        if (player.hasMoved() && player.getY() == 0)
        {
            Greenfoot.delay(7);
            Greenfoot.setWorld(new ForestMap2());
            bgm.stop();
        }
        else if (player.hasMoved() && gen.nextFloat() <= 0.13)
        {
            Greenfoot.delay(7);
            Greenfoot.setWorld(new ForestBattle(player, Greenfoot.getRandomNumber(4)));
            bgm.stop();
            //Greenfoot.delay(5);
        }
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new ForestBattle(player, 3));
            bgm.stop();
        }
        else if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(new MainMenu());
            bgm.stop();
        }
    }
}
