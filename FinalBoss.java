import greenfoot.*;

/** 500, 135 location
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Monster
{
       public FinalBoss()
    {
        super();
        GreenfootImage boss = new GreenfootImage("images/monsters/toilet.png");
        boss.scale(350, 350);
        setImage(boss);
        
        health = 250;
        strength = 10;
        defense = 10;
        piety = 0;
        will = 8;
        speed = 9001;
    }
    
    /**
     * Attack with a physical attack
     * @return the amount of damage dealt
     */
    public int attack(Character player)
    {
        int damage = 0;
        int playDef = player.getDefense();
        
        damage = ((strength * 5) / playDef) + 6;
        if (damage == 0) damage = 1;
        return damage;
    }
    
    /**
     * Attack with a magical attack
     * @return the amount of damage dealt
     */
    public int cast(Character player)
    {
        // Do nothing if Monster has no magic attacks
        return 0;
    }
}
