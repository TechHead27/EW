import greenfoot.*;

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    private boolean moved, movable;
    private int x, y;
    public static final int TILESIZE = 1;
    public static final int MOVEDELAY = 10;
    
    GreenfootImage player = new GreenfootImage("images/priest/priest_victory1.png");

    /**
     * Variables for RPG-ness
     * health:   the player's Hit Points
     * faith:    the player's Magic Points
     * strength: the player's physical strength
     * defense:  the player's physical defense
     * piety:    the player's magic strength
     * will:     the player's magic defense
     * speed:    the player's speed
     * maxHP:    the player's maximum health
     */
    private int health, faith;
    private int strength, defense, piety, will, speed;
    private int maxHP, maxMP;
    
    public Character(int startx, int starty)
    {
        moved = false;
        movable = true;
        
        player.scale(70, 70);
        setImage(player);
        x = startx;
        y = starty;
        
        health = 100;
        faith = 50;
        strength = 15;
        defense = 15;
        piety = 15;
        will = 15;
        speed = 15;
        maxHP = 100;
        maxMP = 50;
    }
    
    public void battleReady()
    {
        player.scale(140, 140);
        setImage(player);
    }
    
    public void exploreReady()
    {
        player.scale(70, 70);
        setImage(player);
    }
    
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(movable)
        {
            if (Greenfoot.isKeyDown("up"))
            {
                y -= TILESIZE;
                if (y < 0) 
                    y = 0;
                moved = true;
                Greenfoot.delay(MOVEDELAY);
            }
            else if (Greenfoot.isKeyDown("down"))
            {
                y += TILESIZE;
                if (y >= getWorld().getHeight()) 
                    y = getWorld().getHeight() - 1;
                moved = true;
                Greenfoot.delay(MOVEDELAY);
            }
            else if (Greenfoot.isKeyDown("left"))
            {
                x -= TILESIZE;
                if (x < 0) 
                    x = 0;
                moved = true;
                Greenfoot.delay(MOVEDELAY);
            }
            else if (Greenfoot.isKeyDown("right"))
            {
                x += TILESIZE;
                if (x >= getWorld().getWidth()) 
                    x = getWorld().getWidth() - 1;
                moved = true;
                Greenfoot.delay(MOVEDELAY);
            }
        
            setLocation(x, y);
        }
    }
    
    /**
     * Attack with a physical attack
     * @return the amount of damage dealt
     */
    public int attack(Monster m)
    {
        
        int damage = 0;
        int monDef = m.getDefense();
        
        damage = (strength * 2) / (monDef * 3);
        if (damage == 0) 
            damage = 1;
        return damage;
    }
    
    /**
     * Attack with a magical attack
     * @return the amount of damage dealt
     */
    public int cast(Monster m, int cost)
    {
        int damage = 0;
        int monMDef = m.getWill();
        faith -= cost;
        
        damage = (piety * 2) / (monMDef * 3);
        if (damage == 0) 
            damage = 1;
        return damage;
    }
    
    /**
     * Heal up to 5% of your faith back
     * @return the amount of faith recovered
     */
    public int pray()
    {
        int recover, temp = 0;
        temp = (int)(maxMP * 0.05);
        recover = java.lang.Math.min(Greenfoot.getRandomNumber(temp+1), maxMP - faith);
        return recover;
    }
    
    /**
     * Heal 15% of your health back
     * @return the amount of health recovered
     */
    public int heal()
    {
        int recover, temp;
        temp = (int)(maxHP * 0.15);
        recover = java.lang.Math.min(temp, maxHP - health);
        return recover;
    }
    
    public boolean hasMoved()
    {
        boolean ret = moved;
        moved = false;
        return ret;
    }
    
    /** GETTERS AND SETTERS **/
    public boolean getMovable()
    {
        return movable;
    }
    
    public void setMovable(boolean canMove)
    {
        movable = canMove;
    }
    
    public int getHealthPercent()
    {
        return health * 100 / maxHP;
    }
    
    public int getFaithPercent()
    {
        return faith * 100 / maxMP;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int hp)
    {
        health = hp;
    }
    
    public int getFaith()
    {
        return faith;
    }
    
    public void setFaith(int mp)
    {
        faith = mp;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public void setStrength(int str)
    {
        strength = str;
    }
    
    public int getDefense()
    {
        return defense;
    }
    
    public void setDefense(int def)
    {
        defense = def;
    }
    
    public int getPiety()
    {
        return piety;
    }
    
    public void setPiety(int mStr)
    {
        piety = mStr;
    }
    
    public int getWill()
    {
        return will;
    }
    
    public void setWill(int william)
    {
        will = william;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
