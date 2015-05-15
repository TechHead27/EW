import greenfoot.*;

/**
 * Setting this as basis for battles, assuming we will
 * have multiple different types of battlefields.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleField extends World
{
    public static String WRECK = "Attack ";
    public static String REKT  = "Attacked by ";
    public static String DEAD  = "You died!";
    public static String WIN   = " defeated!";
    /**
     * Constructor for objects of class BattleField.
     * 
     */
    public BattleField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    /**
     * Do the battle sequences with 3 enemies.
     */
    /*public void battleAll(Character player, Monster enemy1, Monster enemy2, Monster enemy3)
    {
        int speedP, speed1, speed2, speed3;
        int playerSpeed = 0;
        if (enemy3 != null)
        {
            // do the battle stuff
            speedP = player.getSpeed();
            speed1 = enemy1.getSpeed();
            speed2 = enemy2.getSpeed();
            speed3 = enemy3.getSpeed();
            
            if (speedP < speed1) playerSpeed++;
            if (speedP < speed2) playerSpeed++;
            if (speedP < speed3) playerSpeed++;
        }
        else
        {
            battleTwo(player, enemy1, enemy2);
        }
    }*/
    
    /**
     * Do the battle sequences with 2 enemies.
     */
    /*public void battleTwo(Character player, Monster enemy1, Monster enemy2)
    {
        int speedP, speed1, speed2;
        if (enemy2 != null)
        {
            // do the battle stuff
            speedP = player.getSpeed();
            speed1 = enemy1.getSpeed();
            speed2 = enemy2.getSpeed();
        }
        else
        {
            battleSingleCombat(player, enemy1);
        }
    }*/
    
    /**
     * Do the battle sequences 1-on-1
     * @param player The player
     * @param enemy1 The target of the attack
     */
    /*public void battleSingleCombat(Character player, Monster enemy1)
    {
        int speedP, speed1;
        int playerSpeed = 0;
        int damage;
        // do the battle stuff
        speedP = player.getSpeed();
        speed1 = enemy1.getSpeed();
        
        if (speedP < speed1) playerSpeed++;
        if (playerSpeed == 0)
        {
            // Player is faster than the enemy
            // work on setting up the kind of attack as a parameter
            doPhysicalBattle(player, enemy1);
        }
        else
        {
            // Enemy is faster than the player
            doPhysicalBattle(enemy1, player);
        }
    }*/
    
    /**
     * Back and forth physical attacking.
     * @param first The Actor who attacks first
     * @param second The Actor who attacks second
     */
    /*public void doPhysicalBattle(Actor first, Actor second)
    {
        int damage;
        boolean playerFirst = first.getClass().getName().equals("Character");
        
        damage = 1;//damage = first.attack(second);
        if (second.getHealth() - damage <= 0)
        {
            removeObject(second);
            showText((!playerFirst ? "You died!" : "Monster defeated!"), 400, 360);
            Greenfoot.delay(50);
        }
        else
        {
            second.setHealth(second.getHealth() - damage);
            showText("Attacked " + (!playerFirst ? "by " : ""), 400, 360);
            
            damage = 1;//damage = second.attack(first);
            if (first.getHealth() - damage <= 0)
            {
                removeObject(first);
                showText((playerFirst ? "You died!" : "Monster defeated!"), 400, 360);
                Greenfoot.delay(50);
            }
            else
            {
                first.setHealth(first.getHealth() - damage);
            }
        }
        
        if (playerFirst)
        {
            if (first.getHealth() <= 0) Greenfoot.stop();
        }
        else
        {
            if (second.getHealth() <= 0) Greenfoot.stop();
        }
    }*/
}
