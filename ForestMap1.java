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
        player = new Character();
        addObject(player, 300, 200);
        Greenfoot.delay(15);
        gen = new java.util.Random();
        bgm = new GreenfootSound("BGM/Forest1.mp3");
        bgm.playLoop();
    }
    
    public void act()
    {
        if (player.hasMoved() && gen.nextFloat() <= 0.13)
        {
            Greenfoot.setWorld(new ForestBattle());
            bgm.stop();
        }
    }
}
