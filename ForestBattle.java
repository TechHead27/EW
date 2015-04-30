import greenfoot.*;

/**
 * Write a description of class ForestBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestBattle extends World
{

    private Monster enemy;
    private HealthBar healthBar;
    private Character player;
    /**
     * Constructor for objects of class ForestBattle.
     * 
     */
    public ForestBattle(Character c)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        showText("Monster appeared!", 300, 200);
        setBackground("images/burlap.jpg");
        enemy = new Slime();
        addObject(enemy, 500, 100);
        player = c;
        addObject(player, 100, 300);
        healthBar = new HealthBar();
        addObject(healthBar, 100, 360);
        Greenfoot.delay(35);
        player = c;
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            removeObject(enemy);
            showText("Monster defeated!", 300, 200);
            GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
            victory.playLoop();
            Greenfoot.delay(150);
            victory.stop();
            Greenfoot.setWorld(new ForestMap1(player));
        }
    }
}
