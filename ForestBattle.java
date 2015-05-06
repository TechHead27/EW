import greenfoot.*;

/**
 * Write a description of class ForestBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestBattle extends BattleField
{
    private Monster enemy1, enemy2, enemy3;
    private HealthBar healthBar;
    private FaithBar faithBar;
    private Character player;
    private GreenfootSound bgm;
    private int numEnemies;
    
    /**
     * Constructor for objects of class ForestBattle.
     * 
     */
    public ForestBattle(Character c, int enemies)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        showText("Monster appeared!", 400, 360);
        setBackground("images/burlap.jpg");

        createEnemies(enemies);

        player = c;
        player.setMovable(false);
        player.battleReady();
        addObject(player, 100, 200);
        
        healthBar = new HealthBar(player);
        addObject(healthBar, 100, 30);
        faithBar = new FaithBar(player);
        addObject(faithBar, 100, 80);
        
        
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
            removeObject(enemy1);
            showText("Monster defeated!", 400, 360);
            GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
            victory.playLoop();
            Greenfoot.delay(150);
            victory.stop();
            Greenfoot.setWorld(new ForestMap1(player));
        }
        else if(Greenfoot.isKeyDown("1") && enemy1 != null && enemy1.getWorld() != null)
        {
            int damage;
            if (player.getSpeed() > enemy1.getSpeed())
            {
                if (player.getFaith() - 4 < 0)
                {
                    damage = player.attack(enemy1);
                }
                else
                {
                    damage = player.cast(enemy1, 4);
                    faithBar.setFaithImage(player);
                }
                // if the damage was enough to kill the monster
                if (enemy1.getHealth() - damage <= 0)
                {
                    removeObject(enemy1);
                    showText("Monster defeated!", 400, 360);
                    Greenfoot.delay(50);
                    numEnemies--;
                }
                else
                {
                    enemy1.setHealth(enemy1.getHealth() - damage);
                    showText("Attacked " + enemy1.getClass().getName(), 400, 360);
                    damage = enemy1.chooseAttack(player);
                    Greenfoot.delay(50);
                    // if the damage was enough to kill the player
                    if (player.getHealth() - damage <= 0)
                    {
                        bgm.stop();
                        removeObject(player);
                        //removeObject(healthBar);
                        showText("You died!", 400, 360);
                        Greenfoot.stop();
                    }
                    else
                    {
                        showText("Attacked by " + enemy1.getClass().getName(), 400, 360);
                        player.setHealth(player.getHealth() - damage);
                        healthBar.setHealthImage(player);
                        Greenfoot.delay(50);
                    }
                }
            }
            // monster is faster O.O
            else
            {
                damage = enemy1.chooseAttack(player);
                // if the damage was enough to kill the player
                if (player.getHealth() - damage <= 0)
                {
                    bgm.stop();
                    removeObject(player);
                    //removeObject(healthBar);
                    showText("You died!", 400, 360);
                    Greenfoot.stop();
                }
                else
                {
                    showText("Attacked by " + enemy1.getClass().getName(), 400, 360);
                    player.setHealth(player.getHealth() - damage);
                    healthBar.setHealthImage(player);
                    Greenfoot.delay(50);
                    if (player.getFaith() - 4 <= 0)
                    {
                        damage = player.attack(enemy1);
                    }
                    else
                    {
                        damage = player.cast(enemy1, 4);
                        faithBar.setFaithImage(player);
                    }
                    // if the damage was enough to kill the monster
                    if (enemy1.getHealth() - damage <= 0)
                    {
                        removeObject(enemy1);
                        showText("Monster defeated!", 400, 360);
                        Greenfoot.delay(50);
                        numEnemies--;
                    }
                    else
                    {
                        enemy1.setHealth(enemy1.getHealth() - damage);
                        showText("Attacked " + enemy1.getClass().getName(), 400, 360);
                        Greenfoot.delay(50);
                    }
                }
            }
        }
        else if(Greenfoot.isKeyDown("2") && enemy2 != null && enemy2.getWorld() != null)
        {
            int damage;
            if (player.getSpeed() > enemy2.getSpeed())
            {
                damage = player.attack(enemy2);
                // if the damage was enough to kill the monster
                if (enemy2.getHealth() - damage <= 0)
                {
                    removeObject(enemy2);
                    showText("Monster defeated!", 400, 360);
                    Greenfoot.delay(50);
                    numEnemies--;
                }
                else
                {
                    enemy2.setHealth(enemy2.getHealth() - damage);
                    showText("Attacked " + enemy2.getClass().getName(), 400, 360);
                    damage = enemy2.chooseAttack(player);
                    Greenfoot.delay(50);
                    // if the damage was enough to kill the player
                    if (player.getHealth() - damage <= 0)
                    {
                        bgm.stop();
                        removeObject(player);
                        //removeObject(healthBar);
                        showText("You died!", 400, 360);
                        Greenfoot.stop();
                    }
                    else
                    {
                        showText("Attacked by " + enemy2.getClass().getName(), 400, 360);
                        player.setHealth(player.getHealth() - damage);
                        healthBar.setHealthImage(player);
                        Greenfoot.delay(50);
                    }
                }
            }
            // monster is faster O.O
            else
            {
                damage = enemy2.chooseAttack(player);
                // if the damage was enough to kill the player
                if (player.getHealth() - damage <= 0)
                {
                    bgm.stop();
                    removeObject(player);
                    //removeObject(healthBar);
                    showText("You died!", 400, 360);
                    Greenfoot.stop();
                }
                else
                {
                    showText("Attacked by " + enemy2.getClass().getName(), 400, 360);
                    player.setHealth(player.getHealth() - damage);
                    healthBar.setHealthImage(player);
                    damage = player.attack(enemy2);
                    Greenfoot.delay(50);
                    // if the damage was enough to kill the monster
                    if (enemy2.getHealth() - damage <= 0)
                    {
                        removeObject(enemy2);
                        showText("Monster defeated!", 400, 360);
                        Greenfoot.delay(50);
                        numEnemies--;
                    }
                    else
                    {
                        enemy2.setHealth(enemy2.getHealth() - damage);
                        showText("Attacked " + enemy2.getClass().getName(), 400, 360);
                        Greenfoot.delay(50);
                    }
                }
            }
        }
        else if(Greenfoot.isKeyDown("3") && enemy3 != null && enemy3.getWorld() != null)
        {
            int damage;
            if (player.getSpeed() > enemy3.getSpeed())
            {
                damage = player.attack(enemy3);
                // if the damage was enough to kill the monster
                if (enemy3.getHealth() - damage <= 0)
                {
                    removeObject(enemy3);
                    showText("Monster defeated!", 400, 360);
                    Greenfoot.delay(50);
                    numEnemies--;
                }
                else
                {
                    enemy3.setHealth(enemy3.getHealth() - damage);
                    showText("Attacked " + enemy3.getClass().getName(), 400, 360);
                    damage = enemy3.chooseAttack(player);
                    Greenfoot.delay(50);
                    // if the damage was enough to kill the player
                    if (player.getHealth() - damage <= 0)
                    {
                        bgm.stop();
                        removeObject(player);
                        //removeObject(healthBar);
                        showText("You died!", 400, 360);
                        Greenfoot.stop();
                    }
                    else
                    {
                        showText("Attacked by " + enemy3.getClass().getName(), 400, 360);
                        player.setHealth(player.getHealth() - damage);
                        healthBar.setHealthImage(player);
                        Greenfoot.delay(50);
                    }
                }
            }
            // monster is faster O.O
            else
            {
                damage = enemy3.chooseAttack(player);
                // if the damage was enough to kill the player
                if (player.getHealth() - damage <= 0)
                {
                    bgm.stop();
                    removeObject(player);
                    //removeObject(healthBar);
                    showText("You died!", 400, 360);
                    Greenfoot.stop();
                }
                else
                {
                    showText("Attacked by " + enemy3.getClass().getName(), 400, 360);
                    player.setHealth(player.getHealth() - damage);
                    healthBar.setHealthImage(player);
                    damage = player.attack(enemy3);
                    Greenfoot.delay(50);
                    // if the damage was enough to kill the monster
                    if (enemy3.getHealth() - damage <= 0)
                    {
                        removeObject(enemy3);
                        showText("Monster defeated!", 400, 360);
                        Greenfoot.delay(50);
                        numEnemies--;
                    }
                    else
                    {
                        enemy2.setHealth(enemy3.getHealth() - damage);
                        showText("Attacked " + enemy3.getClass().getName(), 400, 360);
                        Greenfoot.delay(50);
                    }
                }
            }
        }
        // no one but jt ever run this command unless you want possible exceptions
        else if (Greenfoot.isKeyDown("8"))
        {
            //battleAll(player, enemy1, null, null);
            //healthBar.sethealthImage(player);
        }
        
        if (numEnemies == 0)
        {
            bgm.stop();
            showText("Monster defeated!", 400, 360);
            GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
            victory.playLoop();
            Greenfoot.delay(150);
            victory.stop();
            Greenfoot.setWorld(new ForestMap1(player));
        }
        else 
        {
            showText("", 400, 360);
        }
    }
    
    /**
     * Create the enemies on screen.
     */
    private void createEnemies(int enemies)
    {
        int monster;
        
        if (enemies >= 0)
        {
            monster = Greenfoot.getRandomNumber(5); // We need each so there is a different monster in each slot
            enemy1 = randomMonster(monster);
            addObject(enemy1, 390, 60);
            numEnemies++;
        }
        if (enemies >= 2)
        {
            monster = Greenfoot.getRandomNumber(5); // We need each so there is a different monster in each slot
            enemy2 = randomMonster(monster);
            addObject(enemy2, 520, 110);
            numEnemies++;
        }
        if (enemies == 3)
        {
            monster = Greenfoot.getRandomNumber(5); // We need each so there is a different monster in each slot
            enemy3 = randomMonster(monster);
            addObject(enemy3, 390, 180);
            numEnemies++;
        }
    }
    
    /**
     * Pick the right monster from the array.
     * 0 - Slime, 1 - Blue Wolf, 2 - Red Wolf, 3 - Yellow Wolf, 4 - Skull Spider
     */
    private Monster randomMonster(int index)
    {
        if (index == 0)
        {
            return new Slime();
        }
        if (index == 1)
        {
            return new BlueWolf();
        }
        if (index == 2)
        {
            return new RedWolf();
        }
        if (index == 3)
        {
            return new YellowWolf();
        }
        if (index == 4)
        {
            return new SkullSpider();
        }
        return null;
    }
}
