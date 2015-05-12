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
    private GreenfootImage background;
    
    /**
     * Constructor for objects of class ForestBattle.
     * 
     */
    public ForestBattle(Character c, int enemies)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        showText("Monster appeared!", 400, 360);
        background = new GreenfootImage("images/menus/battlemenu(1).png");
        background.scale(600, 400);
        setBackground(background);

        createEnemies(enemies);

        player = c;
        player.setMovable(false);
        player.battleReady();
        addObject(player, 100, 160);
        
        healthBar = new HealthBar(player);
        addObject(healthBar, 100, 25);
        faithBar = new FaithBar(player);
        addObject(faithBar, 100, 67);
        
        
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
            doBattle();
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
    
    /**
     * Attack the monster with physical attack
     * @param enemy The enemy being attacked
     */
    public int attackMonster(Monster enemy)
    {
        return player.attack(enemy1);
    }
    
    /**
     * Attack the monster with magical attack
     * @param enemy The enemy being attacked
     */
    public int castMonster(Monster enemy, int cost)
    {
        int temp = player.cast(enemy1, cost);
        faithBar.setFaithImage(player);
        return temp;
    }
    
    /**
     * Attack the player with physical or magical
     * @param enemy The enemy attacking the player
     */
    public int attackPlayer(Monster enemy)
    {
        return enemy.chooseAttack(player);
    }
    
    /**
     * Killed the monster
     * @param enemy The enemy that was killed
     */
    public void killMonster(Monster enemy)
    {
        removeObject(enemy1);
        showText(BattleField.WIN, 400, 360);
        Greenfoot.delay(50);
        numEnemies--;
    }
    
    /**
     * Player was killed
     */
    public void killPlayer()
    {
        player.setHealth(0);
        healthBar.setHealthImage(player);
        bgm.stop();
        removeObject(player);
        showText(BattleField.DEAD, 400, 360);
        Greenfoot.stop();
    }
    
    public void doBattle()
    {
        int damage;
            if (player.getSpeed() > enemy1.getSpeed())
            {
                if (player.getFaith() - 4 < 0)
                {
                    damage = attackMonster(enemy1);
                }
                else
                {
                    damage = castMonster(enemy1, 4);
                }
                // if the damage was enough to kill the monster
                if (enemy1.getHealth() - damage <= 0)
                {
                    killMonster(enemy1);
                }
                else
                {
                    enemy1.setHealth(enemy1.getHealth() - damage);
                    showText(BattleField.WRECK + enemy1.getClass().getName(), 400, 360);
                    damage = attackPlayer(enemy1);
                    Greenfoot.delay(50);
                    // if the damage was enough to kill the player
                    if (player.getHealth() - damage <= 0)
                    {
                        killPlayer();
                    }
                    else
                    {
                        showText(BattleField.REKT + enemy1.getClass().getName(), 400, 360);
                        player.setHealth(player.getHealth() - damage);
                        healthBar.setHealthImage(player);
                        Greenfoot.delay(50);
                    }
                }
            }
            // monster is faster O.O
            else
            {
                damage = attackPlayer(enemy1);
                // if the damage was enough to kill the player
                if (player.getHealth() - damage <= 0)
                {
                    killPlayer();
                }
                else
                {
                    showText(BattleField.REKT + enemy1.getClass().getName(), 400, 360);
                    player.setHealth(player.getHealth() - damage);
                    healthBar.setHealthImage(player);
                    Greenfoot.delay(50);
                    if (player.getFaith() - 4 <= 0)
                    {
                        damage = attackMonster(enemy1);
                    }
                    else
                    {
                        damage = castMonster(enemy1, 4);
                    }
                    // if the damage was enough to kill the monster
                    if (enemy1.getHealth() - damage <= 0)
                    {
                        killMonster(enemy1);
                    }
                    else
                    {
                        enemy1.setHealth(enemy1.getHealth() - damage);
                        showText(BattleField.WRECK + enemy1.getClass().getName(), 400, 360);
                        Greenfoot.delay(50);
                    }
                }
            }
    }
    
    private void jtjtjtjtjt(Character player, Monster m1, Monster m2, Monster m3)
    {
        int charSpeed = 0;
        if (m1.getSpeed() > player.getSpeed()) charSpeed += 1;
        if (m2.getSpeed() > player.getSpeed()) charSpeed += 3;
        if (m2.getSpeed() > player.getSpeed()) charSpeed += 5;
        
        switch (charSpeed)
        {
            case 0: player.attack(m1);
                    player.attack(m2);
                    player.attack(m3);
                    m1.chooseAttack(player);
                    m2.chooseAttack(player);
                    m3.chooseAttack(player);
                    break;
            // only m1 is faster than player
            case 1: m1.chooseAttack(player);
                    player.attack(m1);
                    player.attack(m2);
                    player.attack(m3);
                    m2.chooseAttack(player);
                    m3.chooseAttack(player);
                    break;
            // only m2 is faster than player
            case 3: m2.chooseAttack(player);
                    player.attack(m1);
                    player.attack(m2);
                    player.attack(m3);
                    m1.chooseAttack(player);
                    m3.chooseAttack(player);
                    break;
            // only m3 is faster than player
            case 5: m3.chooseAttack(player);
                    player.attack(m1);
                    player.attack(m2);
                    player.attack(m3);
                    m1.chooseAttack(player);
                    m2.chooseAttack(player);
                    break;
            // m1 and m2 are faster than player
            case 4: m1.chooseAttack(player);
                    m2.chooseAttack(player);
                    player.attack(m1);
                    player.attack(m2);
                    player.attack(m3);
                    m3.chooseAttack(player);
                    break;
            // m1 and m3 are faster than player
            case 6: m1.chooseAttack(player);
                    m3.chooseAttack(player);
                    player.attack(m1);
                    player.attack(m2);
                    player.attack(m3);
                    m2.chooseAttack(player);
                    break;
            // m2 and m3 are faster than player
            case 8: m2.chooseAttack(player);
                    m3.chooseAttack(player);
                    player.attack(m1);
                    player.attack(m2);
                    player.attack(m3);
                    m1.chooseAttack(player);
                    break;
            // all monsters faster than player
            case 9: m1.chooseAttack(player);
                    m2.chooseAttack(player);
                    m3.chooseAttack(player);
                    player.attack(m1);
                    player.attack(m2);
                    player.attack(m3);
                    break;
        }
    }
}
