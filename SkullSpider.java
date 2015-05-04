import greenfoot.*;

/**
 * Write a description of class SkullSpider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkullSpider extends Monster
{
    public SkullSpider()
    {
        super();
        GreenfootImage spider = new GreenfootImage("images/monsters/skull_spider.png");
        spider.scale(75, 75);
        setImage(spider);
        
        health = 15;
        strength = 2;
        defense = 8;
        piety = 1;
        will = 3;
        speed = 7;
    }
    
    /**
     * Attack with a physical attack
     * @return the amount of damage dealt
     */
    public int attack(Character player)
    {
        int damage = 0;
        int playDef = player.getDefense();
        
        damage = (strength * 2) / (playDef * 3);
        if (damage == 0) damage = 1;
        return damage;
    }
    
    /**
     * Attack with a magical attack
     * @return the amount of damage dealt
     */
    public int cast(Character player)
    {
        int damage = 0;
        int playMDef = player.getWill();
        
        damage = (piety * 2) / playMDef;
        if (damage == 0) damage = 1;
        return damage;
    }
    
    /**
     * Act - do whatever the SkullSpider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
