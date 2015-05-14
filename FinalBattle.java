import greenfoot.*;

/**
 * Write a description of class FinalBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBattle extends BattleField
{
    private Monster boss;
    private HealthBar healthBar;
    private FaithBar faithBar;
    private Character player;
    private GreenfootSound bgm;
    private GreenfootImage background;
    
    public FinalBattle(Character c)
    {
        super();
        showText("Toilet appeared!", 400, 360);
        background = new GreenfootImage("images/menus/battlemenu(2).png");
        background.scale(600, 400);
        setBackground(background);
        
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
    
    public void act()
    {
        showText("", 400, 360);
        if (Greenfoot.isKeyDown("7"))
        {
            bgm.stop();
            removeObject(boss);
            GreenfootSound victory = new GreenfootSound("BGM/VictoryFanFare.mp3");
            victory.playLoop();
            
            showText("YOU HAVE PROTECTED THE WORLD FROM",300,270);
            showText("THE EVIL POSSESED TOILET.",300,290);
            Greenfoot.delay(100);
            
            while(!Greenfoot.isKeyDown("enter")) {
                showText("YOU HAVE FREED THE PEOPLE OF THEIR FEAR OF", 300, 270);
                showText("POOPING AND CLOSED THE SWIRLING VORTEX WITHIN.", 300, 290);
            }
            Greenfoot.delay(50);
            while(!Greenfoot.isKeyDown("enter")) {
                
            }
            Greenfoot.delay(5);
            victory.stop();
            Greenfoot.setWorld(new Credits("images/credits/credits1.png"));
        }
    }
}
