import greenfoot.*;

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Monster extends Actor
{
    /**
     * Variables for RPG-ness
     * health:   the monster's Hit Points
     * strength: the monster's physical strength
     * defense:  the monster's physical defense
     * piety:    the monster's magic strength
     * will:     the monster's magic defense
     * speed:    the monster's speed
     */
    public int health, strength, defense, piety, will, speed;
    
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    /**
     * Choose which attack a monster will execute
     */
    public int chooseAttack(Character player)
    {
        int damage = 0;
        damage = attack(player);
        if (cast(player) > damage)
        {
            damage = cast(player);
        }
        
        return damage;
    }
    
    public abstract int attack(Character player);
    public abstract int cast(Character player);
    
    /** GETTERS **/
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int hp)
    {
        health = hp;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public int getDefense()
    {
        return defense;
    }
    
    public int getPiety()
    {
        return piety;
    }
    
    public int getWill()
    {
        return will;
    }
    
    public int getSpeed()
    {
        return speed;
    }
}
