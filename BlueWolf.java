import greenfoot.*;

/**
 * Write a description of class BlueWolf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueWolf extends Wolf
{
    public BlueWolf()
    {
        super();
        GreenfootImage wolf = new GreenfootImage("images/monsters/wolf_blue.png");
        wolf.scale(120, 120);
        setImage(wolf);
        
        health = 35;
        strength = 4;
        defense = 4;
        piety = 3;
        will = 10;
        speed = 10;
    }
    
    /**
     * Attack with a physical attack
     * @return the amount of damage dealt
     */
    public int attack(Character player)
    {
        int damage = 0;
        int playDef = player.getDefense();
        
        damage = (strength * 3) / (playDef * 2);
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
        
        damage = (piety * 2) / (playMDef * 3);
        if (damage == 0) damage = 1;
        return damage;
    }
    
    /**
     * Act - do whatever the BlueWolf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
