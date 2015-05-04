import greenfoot.*;

/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slime extends Monster
{
    public Slime()
    {
        super();
        GreenfootImage slime = new GreenfootImage("images/monsters/Slime.png");
        slime.scale(120, 120);
        setImage(slime);
        
        health = 20;
        strength = 3;
        defense = 2;
        piety = 0;
        will = 0;
        speed = 4;
    }
    
    /**
     * Act - do whatever the Slime wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
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
        // Do nothing if Monster has no magic attacks
        return 0;
    }
}
