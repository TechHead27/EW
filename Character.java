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
    private String name = "Chive";

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
    private int maxHP, maxMP, curExp, nextLvl, lvl;
    
    public Character(int startx, int starty)
    {
        moved = false;
        movable = true;
        GreenfootImage player = new GreenfootImage("images/priest/priest_victory1.png");
        player.scale(70, 70);
        setImage(player);
        x = startx;
        y = starty;
        
        health = 100;
        faith = 100;
        strength = 15;
        defense = 15;
        piety = 15;
        will = 15;
        speed = 15;
        maxHP = 100;
        maxMP = 100;
        
        curExp = 0;
        nextLvl = 100;
        lvl = 1;
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
                if (y < 0) y = 0;
                moved = true;
                Greenfoot.delay(MOVEDELAY);
            }
            else if (Greenfoot.isKeyDown("down"))
            {
                y += TILESIZE;
                if (y >= getWorld().getHeight()) y = getWorld().getHeight() - 1;
                moved = true;
                Greenfoot.delay(MOVEDELAY);
            }
            else if (Greenfoot.isKeyDown("left"))
            {
                x -= TILESIZE;
                if (x < 0) x = 0;
                moved = true;
                Greenfoot.delay(MOVEDELAY);
            }
            else if (Greenfoot.isKeyDown("right"))
            {
                x += TILESIZE;
                if (x >= getWorld().getWidth()) x = getWorld().getWidth() - 1;
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
        if (damage == 0) damage = 1;
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
        if (damage == 0) damage = 1;
        return damage;
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
    
    public static final int TILESIZE = 1;
    public static final int MOVEDELAY = 10;
}
