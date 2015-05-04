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
    private GreenfootSound bgm;
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
        player.setMovable(false);
        addObject(player, 100, 300);
        healthBar = new HealthBar(player);
        addObject(healthBar, 100, 360);
        bgm = new GreenfootSound("BGM/BattleTheme1.mp3");
        bgm.playLoop();
        Greenfoot.delay(35);
        player = c;
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            bgm.stop();
            removeObject(enemy);
            showText("Monster defeated!", 300, 200);
            GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
            victory.playLoop();
            Greenfoot.delay(150);
            victory.stop();
            Greenfoot.setWorld(new ForestMap1(player));
        }
        else if(Greenfoot.isKeyDown("1"))
        {
            int damage;
            if (player.getSpeed() > enemy.getSpeed())
            {
                damage = player.attack(enemy);
                // if the damage was enough to kill the monster
                if (enemy.getHealth() - damage <= 0)
                {
                    bgm.stop();
                    removeObject(enemy);
                    showText("Monster defeated!", 300, 200);
                    GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
                    victory.playLoop();
                    Greenfoot.delay(150);
                    victory.stop();
                    Greenfoot.setWorld(new ForestMap1(player));
                }
                else
                {
                    enemy.setHealth(enemy.getHealth() - damage);
                    damage = enemy.attack(player);
                    // if the damage was enough to kill the player
                    if (player.getHealth() - damage <= 0)
                    {
                        bgm.stop();
                        removeObject(player);
                        removeObject(healthBar);
                        showText("You died!", 300, 200);
                        Greenfoot.stop();
                    }
                    else
                    {
                        player.setHealth(player.getHealth() - damage);
                        healthBar.setHealthImage(player);
                    }
                }
            }
            // monster is faster O.O
            else
            {
                damage = enemy.attack(player);
                // if the damage was enough to kill the player
                if (player.getHealth() - damage <= 0)
                {
                    bgm.stop();
                    removeObject(player);
                    removeObject(healthBar);
                    showText("You died!", 300, 200);
                    Greenfoot.stop();
                }
                else
                {
                    player.setHealth(player.getHealth() - damage);
                    healthBar.setHealthImage(player);
                    damage = player.attack(enemy);
                    // if the damage was enough to kill the monster
                    if (player.getHealth() - damage <= 0)
                    {
                        bgm.stop();
                        removeObject(enemy);
                        showText("Monster defeated!", 300, 200);
                        GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
                        victory.playLoop();
                        Greenfoot.delay(150);
                        victory.stop();
                        Greenfoot.setWorld(new ForestMap1(player));
                    }
                    else
                    {
                        enemy.setHealth(enemy.getHealth() - damage);
                    }
                }
            }
            Greenfoot.delay(50);
        }
    }
}
