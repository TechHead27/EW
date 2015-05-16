import greenfoot.*;

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends Monster
{
    public Skeleton()
    {
        super();
        GreenfootImage skeleton = new GreenfootImage("images/monsters/skeleton.png");
        skeleton.scale(50, 90);
        setImage(skeleton);
        
        health = 30;
        strength = 7;
        defense = 8;
        piety = 3;
        will = 5;
        speed = 4;
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
}
