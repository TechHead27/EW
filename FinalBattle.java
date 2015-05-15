import greenfoot.*;

/**
 * Write a description of class FinalBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBattle extends BattleField
{
    private final int[][] options = {{75, 304}, {75, 330}, {75, 356}};//, {75, 382}};
    private Monster boss;
    private HealthBar healthBar;
    private FaithBar faithBar;
    private Character player;
    private GreenfootSound bgm;
    private GreenfootImage background;
    
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
        showText("RUN", 155, 376);
        showText("Cannot run from this toilet!", 358, 376);
        
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
        showText("", 300, 244);
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
