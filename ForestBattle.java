import greenfoot.*;

/**
 * Write a description of class ForestBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestBattle extends BattleField
{   
    private static final int[][] options = {{75, 304}, {75, 330}, {75, 356}, {75, 382}};
    private Monster enemy1, enemy2, enemy3;
    private HealthBar healthBar;
    private FaithBar faithBar;
    private Character player;
    private GreenfootSound bgm;
    private int numEnemies;
    private GreenfootImage background;
    private boolean alreadyActing;
    private int last;
    
    private Arrow selector;
    private Box enemySelector = new Box(false);
    
    /**
     * Constructor for objects of class ForestBattle.
     * 
     */
    public ForestBattle(Character c, int enemies)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        background = new GreenfootImage("images/menus/battlemenu.png");
        background.scale(600, 400);
        setBackground(background);
        
        selector = new Arrow(options);
        addObject(selector, 75, 304);
        
        showText("ATTACK", 135, 298);
        showText("Standard physical attack", 350, 298);
        showText("MAGIC", 144, 324);
        showText("Standard magical attack", 347, 324);
        showText("PRAY", 150, 350);
        showText("Recover faith", 296, 350);
        showText("RUN", 155, 376);
        showText("Try to run from battle!", 335, 376);
        
        createEnemies(enemies);
        if(enemy1 != null && enemy2 != null && enemy3 != null)
        {
            if((enemy1.getClass().getName().equals("RedWolf") && enemy2.getClass().getName().equals("BlueWolf") && enemy3.getClass().getName().equals("YellowWolf")) ||
               (enemy1.getClass().getName().equals("RedWolf") && enemy3.getClass().getName().equals("BlueWolf") && enemy2.getClass().getName().equals("YellowWolf")) ||
               (enemy2.getClass().getName().equals("RedWolf") && enemy1.getClass().getName().equals("BlueWolf") && enemy3.getClass().getName().equals("YellowWolf")) ||
               (enemy2.getClass().getName().equals("RedWolf") && enemy3.getClass().getName().equals("BlueWolf") && enemy1.getClass().getName().equals("YellowWolf")) ||
               (enemy3.getClass().getName().equals("RedWolf") && enemy1.getClass().getName().equals("BlueWolf") && enemy2.getClass().getName().equals("YellowWolf")) ||
               (enemy3.getClass().getName().equals("RedWolf") && enemy2.getClass().getName().equals("BlueWolf") && enemy1.getClass().getName().equals("YellowWolf")))
                showText("THUNDERCATS GO!!!!!!", 300, 244);
            else
                showText("Monster appeared!", 300, 244);
        }
        else
            showText("Monster appeared!", 300, 244);
        
        player = c;
        player.setMovable(false);
        player.battleReady();
        addObject(player, 157, 138);
        
        healthBar = new HealthBar(player);
        addObject(healthBar, 77, 20);
        faithBar = new FaithBar(player);
        addObject(faithBar, 225, 20);
        
        
        bgm = new GreenfootSound("BGM/BattleTheme1.mp3");
        bgm.playLoop();
        Greenfoot.delay(35);
        player = c;
        alreadyActing = false;
    }
    
    private void chooseEnemy(boolean physical)
    {
        boolean goBack = false;
        alreadyActing = true;
        if(last == 1 && enemy1 != null && enemy1.getWorld() != null)
            chooseOne();
        else if(last == 2 && enemy2 != null && enemy2.getWorld() != null)
            chooseTwo();
        else if(last == 3 && enemy3 != null && enemy3.getWorld() != null)
            chooseThree();
        else if(enemy1 != null && enemy1.getWorld() != null)
            chooseOne();
        else if(enemy2 != null && enemy2.getWorld() != null)
            chooseTwo();
        else
            chooseThree();
        Greenfoot.delay(50);
        while(!(Greenfoot.isKeyDown(BattleField.ENTER)))
        {
            // currently selecting enemy1
            if(enemySelector.x == 391)
            {
                // go back one enemy
                if(Greenfoot.isKeyDown(BattleField.UP) || Greenfoot.isKeyDown(BattleField.LEFT))
                {
                    // enemy3 exists
                    if(enemy3 != null && enemy3.getWorld() != null)
                    {
                        chooseThree();
                    }
                    // enemy3 does not exist, but enemy2 does
                    else if(enemy2 != null && enemy2.getWorld() != null)
                    {
                        chooseTwo();
                    }
                }
                // go forward one enemy
                else if(Greenfoot.isKeyDown(BattleField.DOWN) || Greenfoot.isKeyDown(BattleField.RIGHT))
                {
                    // enemy2 exists
                    if(enemy2 != null && enemy2.getWorld() != null)
                    {
                        chooseTwo();
                    }
                    // enemy2 does not exist, but enemy3 does
                    else if(enemy3 != null && enemy3.getWorld() != null)
                    {
                        chooseThree();
                    }
                }
            }
            // currently selecting enemy2
            else if(enemySelector.x == 537)
            {
                // go back one enemy
                if(Greenfoot.isKeyDown(BattleField.UP) || Greenfoot.isKeyDown(BattleField.LEFT))
                {
                    // enemy1 exists
                    if(enemy1 != null && enemy1.getWorld() != null)
                    {
                        chooseOne();
                    }
                    // enemy1 does not exist, but enemy3 does
                    else if(enemy3 != null && enemy3.getWorld() != null)
                    {
                        chooseThree();
                    }
                }
                // go forward one enemy
                else if(Greenfoot.isKeyDown(BattleField.DOWN) || Greenfoot.isKeyDown(BattleField.RIGHT))
                {
                    // enemy3 exists
                    if(enemy3 != null && enemy3.getWorld() != null)
                    {
                        chooseThree();
                    }
                    // enemy3 does not exist, but enemy1 does
                    else if(enemy1 != null && enemy1.getWorld() != null)
                    {
                        chooseOne();
                    }
                }
            }
            // currently selecting enemy3
            else
            {
                // go back one enemy
                if(Greenfoot.isKeyDown(BattleField.UP) || Greenfoot.isKeyDown(BattleField.LEFT))
                {
                    // enemy2 exists
                    if(enemy2 != null && enemy2.getWorld() != null)
                    {
                        chooseTwo();
                    }
                    // enemy2 does not exist, but enemy1 does
                    else if(enemy1 != null && enemy1.getWorld() != null)
                    {
                        chooseOne();
                    }
                }
                // go forward one enemy
                else if(Greenfoot.isKeyDown(BattleField.DOWN) || Greenfoot.isKeyDown(BattleField.RIGHT))
                {
                    // enemy1 exists
                    if(enemy1 != null && enemy1.getWorld() != null)
                    {
                        chooseOne();
                    }
                    // enemy1 does not exist, but enemy2 does
                    else if(enemy2 != null && enemy2.getWorld() != null)
                    {
                        chooseTwo();
                    }
                }
            }
            Greenfoot.delay(5);
            if(Greenfoot.isKeyDown(BattleField.SHIFT))
            {
                goBack = true;
                break;
            }
        }
        removeObject(enemySelector);
        showText("", 300, 244);
        if(!goBack)
            melee((enemySelector.x == 391 ? enemy1 : (enemySelector.x == 537 ? enemy2 : enemy3)),
              enemy1, enemy2, enemy3, physical);
        alreadyActing = false;
        Greenfoot.delay(30);
    }
    
    private void chooseOne()
    {
        last = 1;
        removeObject(enemySelector);
        addObject(enemySelector, 391, 52);
        enemySelector.x = 391;
        enemySelector.y = 52;
        showText("Attack " + enemy1.getClass().getName() + "?", 300, 244);
    }
    
    private void chooseTwo()
    {
        last = 2;
        removeObject(enemySelector);
        addObject(enemySelector, 537, 52);
        enemySelector.x = 537;
        enemySelector.y = 52;
        showText("Attack " + enemy2.getClass().getName() + "?", 300, 244);
    }
    
    private void chooseThree()
    {
        last = 3;
        removeObject(enemySelector);
        addObject(enemySelector, 445, 152);
        enemySelector.x = 445;
        enemySelector.y = 152;
        showText(BattleField.WRECK + enemy3.getClass().getName() + "?", 300, 244);
    }
    
    private void prayer()
    {
        int recover;
        alreadyActing = true;
        recover = player.pray();
        showText(BattleField.RECOV + recover + BattleField.FAITH, 300, 244);
        player.setFaith(player.getFaith() + recover);
        faithBar.setFaithImage(player);
        Greenfoot.delay(40);
        monsterTurn(enemy1);
        monsterTurn(enemy2);
        monsterTurn(enemy3);
        Greenfoot.delay(50);
        alreadyActing = false;
    }
    
    private void tryRun()
    {
        int temp = -1;
        alreadyActing = true;
        temp = Greenfoot.getRandomNumber(100);
        if(temp < 75 && temp % 2 == 0)
        {
            showText(BattleField.RUNYES, 300, 244);
            Greenfoot.delay(40);
            bgm.stop();
            Greenfoot.setWorld(new ForestMap1(player));
        }
        else
        {
            showText(BattleField.RUNNO, 300, 244);
            Greenfoot.delay(40);
            monsterTurn(enemy1);
            monsterTurn(enemy2);
            monsterTurn(enemy3);
        }
        alreadyActing = false;
        Greenfoot.delay(50);
    }
    
    public void act()
    {   
        if(!alreadyActing)
        {
            showText("", 300, 244);
            if (Greenfoot.isKeyDown(BattleField.ESCAPE))
            {
                bgm.stop();
                removeObject(enemy1);
                showText(BattleField.CHEAT, 300, 244);
                GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
                victory.playLoop();
                Greenfoot.delay(150);
                victory.stop();
                Greenfoot.setWorld(new ForestMap1(player));
            }
            else if (Greenfoot.isKeyDown(BattleField.ENTER))
            {
                switch (selector.getSelection())
                {
                    case 0: chooseEnemy(true);
                            break;
                    case 1: if(player.getFaith() - 2 >= 0)
                                chooseEnemy(false);
                            else
                            {
                                showText(BattleField.NOMP, 300, 244);
                                Greenfoot.delay(50);
                            }
                            break;
                    case 2: prayer();
                            break;
                    case 3: tryRun();
                            break;
                    default:break;
                }
            }
            // auto go to final boss!
            else if (Greenfoot.isKeyDown("8"))
            {
                bgm.stop();
                Greenfoot.setWorld(new FinalBattle(player));
            }
        
            if (numEnemies == 0)
            {
                bgm.stop();
                showText("Monster defeated!", 300, 244);
                GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
                victory.playLoop();
                Greenfoot.delay(150);
                victory.stop();
                Greenfoot.setWorld(new ForestMap1(player));
            }
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
            addObject(enemy1, 391, 52);
            numEnemies++;
        }
        if (enemies >= 2)
        {
            monster = Greenfoot.getRandomNumber(5); // We need each so there is a different monster in each slot
            enemy2 = randomMonster(monster);
            addObject(enemy2, 537, 52);
            numEnemies++;
        }
        if (enemies == 3)
        {
            monster = Greenfoot.getRandomNumber(5); // We need each so there is a different monster in each slot
            enemy3 = randomMonster(monster);
            addObject(enemy3, 445, 152);
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
     * @return The amount of damage done
     */
    public int attackMonster(Monster enemy)
    {
        showText(BattleField.WRECK + enemy.getClass().getName() + BattleField.FISTS + player.attack(enemy) + BattleField.DAMAGE, 300, 244);
        Greenfoot.delay(60);
        return player.attack(enemy);
    }
    
    /**
     * Attack the monster with magical attack
     * @param enemy The enemy being attacked
     * @return The amount of damage done
     */
    public int castMonster(Monster enemy, int cost)
    {
        int temp = player.cast(enemy, cost);
        faithBar.setFaithImage(player);
        showText(BattleField.WRECK + enemy.getClass().getName() + BattleField.MAGIC + temp + BattleField.DAMAGE, 300, 244);
        Greenfoot.delay(60);
        return temp;
    }
    
    /**
     * Attack the player with physical or magical
     * @param enemy The enemy attacking the player
     * @return The amount of damage done
     */
    public int attackPlayer(Monster enemy)
    {
        showText(BattleField.REKT + enemy.getClass().getName() + BattleField.DEALT + enemy.chooseAttack(player) + BattleField.DAMAGE, 300, 244);
        Greenfoot.delay(60);
        return enemy.chooseAttack(player);
    }
    
    /**
     * Killed the monster
     * @param enemy The enemy that was killed
     */
    public void killMonster(Monster enemy)
    {
        removeObject(enemy);
        showText(enemy.getClass().getName() + BattleField.WIN, 300, 244);
        Greenfoot.delay(60);
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
    
    private void playerTurn(Monster target, boolean physical)
    {
        int damage;
        if(physical)
        {
            damage = attackMonster(target);
            if(target.getHealth() - damage <= 0)
                killMonster(target);
            else
                target.setHealth(target.getHealth() - damage);
        }
        else
        {
            damage = castMonster(target, 2);
            if(target.getHealth() - damage <= 0)
                killMonster(target);
            else
                target.setHealth(target.getHealth() - damage);
        }
    }
    
    private void monsterTurn(Monster fighter)
    {
        int damage;
        if(fighter != null && fighter.getWorld() != null)
        {
            damage = attackPlayer(fighter);
            if(player.getHealth() - damage <= 0)
                killPlayer();
            else
            {
                player.setHealth(player.getHealth() - damage);
                healthBar.setHealthImage(player);
            }
        }
    }
    
    private void melee(Monster target, Monster m1, Monster m2, Monster m3, boolean physical)
    {
        int charSpeed = 0;
        
        if (m1 != null && m1.getWorld() != null && m1.getSpeed() > player.getSpeed()) charSpeed += 1;
        if (m2 != null && m2.getWorld() != null && m2.getSpeed() > player.getSpeed()) charSpeed += 3;
        if (m3 != null && m3.getWorld() != null && m3.getSpeed() > player.getSpeed()) charSpeed += 5;
        
        switch (charSpeed)
        {
            case 0: playerTurn(target, physical);
                    monsterTurn(m1);
                    monsterTurn(m2);
                    monsterTurn(m3);
                    break;
            // only m1 is faster than player
            case 1: monsterTurn(m1);
                    playerTurn(target, physical);
                    monsterTurn(m2);
                    monsterTurn(m3);
                    break;
            // only m2 is faster than player
            case 3: monsterTurn(m2);
                    playerTurn(target, physical);
                    monsterTurn(m1);
                    monsterTurn(m3);
                    break;
            // only m3 is faster than player
            case 5: monsterTurn(m3);
                    playerTurn(target, physical);
                    monsterTurn(m1);
                    monsterTurn(m2);
                    break;
            // m1 and m2 are faster than player
            case 4: monsterTurn(m1);
                    monsterTurn(m2);
                    playerTurn(target, physical);
                    monsterTurn(m3);
                    break;
            // m1 and m3 are faster than player
            case 6: monsterTurn(m1);
                    monsterTurn(m3);
                    playerTurn(target, physical);
                    monsterTurn(m2);
                    break;
            // m2 and m3 are faster than player
            case 8: monsterTurn(m2);
                    monsterTurn(m3);
                    playerTurn(target, physical);
                    monsterTurn(m1);
                    break;
            // all monsters faster than player
            case 9: monsterTurn(m1);
                    monsterTurn(m2);
                    monsterTurn(m3);
                    playerTurn(target, physical);
                    break;
        }
    }
}
