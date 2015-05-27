import greenfoot.*;

/**
 * Write a description of class FinalBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBattle extends BattleField
{
    private final int[][] options = {{75, 304}, {75, 330}, {75, 356}, {75, 382}};
    private Monster boss;
    private HealthBar healthBar;
    private FaithBar faithBar;
    private Character player;
    private GreenfootSound bgm;
    private GreenfootImage background;
    
    private boolean alreadyActing = false;
    
    private Arrow selector;
    
    public FinalBattle(Character c)
    {
        super();
        showText("Toilet appeared!", 300, 244);
        background = new GreenfootImage("images/menus/battlemenu.png");
        background.scale(600, 400);
        setBackground(background);
        selector = new Arrow(options);
        addObject(selector, 75, 304);
        
        //GreenfootImage g = new GreenfootImage("hello", 20, java.awt.Color.green, java.awt.Color.white);
        //selector.setImage(g);
        
        showText("ATTACK", 135, 298);
        showText("Standard physical attack", 350, 298);
        showText("MAGIC", 144, 324);
        showText("Standard magical attack", 347, 324);
        showText("PRAY", 150, 350);
        showText("Recover faith", 296, 350);
        showText("HEAL", 151, 376);
        showText("Recover health", 303, 376);
        
        // set up toilet
        boss = new FinalBoss();
        addObject(boss, 497, 119);
        
        player = c;
        player.setMovable(false);
        player.battleReady();
        addObject(player, 157, 138);
        
        healthBar = new HealthBar(player);
        addObject(healthBar, 77, 20);
        faithBar = new FaithBar(player);
        addObject(faithBar, 225, 20);
        
        bgm = new GreenfootSound("BGM/Boss.mp3");
        bgm.playLoop();
        Greenfoot.delay(35);
        player = c;
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
        bossTurn();
        Greenfoot.delay(40);
        alreadyActing = false;
    }
    
    private void heal()
    {
        int recover;
        alreadyActing = true;
        recover = player.heal();
        showText(BattleField.RECOV + recover + BattleField.HEALTH, 300, 244);
        player.setHealth(player.getHealth() + recover);
        healthBar.setHealthImage(player);
        Greenfoot.delay(40);
        bossTurn();
        Greenfoot.delay(40);
        alreadyActing = false;
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
        showText(BattleField.DEAD, 300, 244);
        Greenfoot.stop();
    }
    
    /**
     * Attack the player with physical or magical
     * @return The amount of damage done
     */
    public int attackPlayer()
    {
        showText(BattleField.REKT + boss.getClass().getName() + BattleField.DEALT + boss.chooseAttack(player) + BattleField.DAMAGE, 300, 244);
        Greenfoot.delay(60);
        return boss.chooseAttack(player);
    }
    
    /**
     * Attack the monster with physical attack
     * @return The amount of damage done
     */
    public int attackMonster()
    {
        showText(BattleField.WRECK + boss.getClass().getName() + BattleField.FISTS + player.attack(boss) + BattleField.DAMAGE, 300, 244);
        Greenfoot.delay(40);
        return player.attack(boss);
    }
    
    /**
     * Attack the monster with magical attack
     * @return The amount of damage done
     */
    public int castMonster(int cost)
    {
        int temp = player.cast(boss, cost);
        faithBar.setFaithImage(player);
        showText(BattleField.WRECK + boss.getClass().getName() + BattleField.MAGIC + temp + BattleField.DAMAGE, 300, 244);
        Greenfoot.delay(40);
        return temp;
    }
    
    private void bossTurn()
    {
        int damage;
        
        damage = attackPlayer();
        if(player.getHealth() - damage <= 0)
            killPlayer();
        else
        {
            player.setHealth(player.getHealth() - damage);
            healthBar.setHealthImage(player);
        }
    }
    
    public void act()
    {
        if(!alreadyActing)
        {
            showText("", 300, 244);
            
            if (Greenfoot.isKeyDown(BattleField.ENTER))
            {
                switch (selector.getSelection())
                {
                    case 0: attackMonster();
                            bossTurn();
                            break;
                    case 1: if (player.getFaith() - 2 >= 0)
                            {
                                castMonster(2);
                                bossTurn();
                            }
                            else
                            {
                                showText(BattleField.NOMP, 300, 244);
                                Greenfoot.delay(40);
                            }
                            break;
                    case 2: prayer();
                            break;
                    case 3: heal();
                            break;
                    default:break;
                }
            }
        }
        
        if(boss == null || boss.getWorld() == null)
        {
            bgm.stop();
            removeObject(boss);
            GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
            victory.playLoop();
            
            showText("YOU HAVE PROTECTED THE WORLD FROM",300,236);
            showText("THE EVIL POSSESED TOILET.",300,256);
            Greenfoot.delay(100);
            
            //while(!Greenfoot.isKeyDown("enter")) {
                showText("YOU HAVE FREED THE PEOPLE OF THEIR FEAR OF", 300, 236);
                showText("POOPING AND CLOSED THE SWIRLING VORTEX WITHIN.", 300, 256);
            //}
            Greenfoot.delay(500);
            //while(!Greenfoot.isKeyDown("enter")) {
                
            //}
            Greenfoot.delay(5);
            victory.stop();
            Greenfoot.setWorld(new Credits("images/credits/credits1.png"));
        }
        
        //showText("", 300, 244);
        if (Greenfoot.isKeyDown("7"))
        {
            bgm.stop();
            removeObject(boss);
            GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
            victory.playLoop();
            
            showText("YOU HAVE PROTECTED THE WORLD FROM",300,236);
            showText("THE EVIL POSSESED TOILET.",300,256);
            Greenfoot.delay(100);
            
            //while(!Greenfoot.isKeyDown("enter")) {
                showText("YOU HAVE FREED THE PEOPLE OF THEIR FEAR OF", 300, 236);
                showText("POOPING AND CLOSED THE SWIRLING VORTEX WITHIN.", 300, 256);
            //}
            Greenfoot.delay(500);
            //while(!Greenfoot.isKeyDown("enter")) {
                
            //}
            Greenfoot.delay(5);
            victory.stop();
            Greenfoot.setWorld(new Credits("images/credits/credits1.png"));
        }
    }
}
