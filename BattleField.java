import greenfoot.*;

/**
 * Setting this as basis for battles, assuming we will
 * have multiple different types of battlefields.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleField extends World
{
    public static final String WRECK = "Attack ";
    public static final String REKT  = "Attacked by ";
    public static final String DEAD  = "You died!";
    public static final String WIN   = " defeated!";
    public static final String RECOV = "Recovered ";
    public static final String FAITH = " faith!";
    public static final String HEALTH= " health!";
    public static final String RUNYES= "Escape success!";
    public static final String RUNNO = "Escape failed!";
    public static final String CHEAT = "Cheater!";
    public static final String NOMP  = "Not enough faith!";
    
    public static final String FISTS = " with fists dealing ";
    public static final String MAGIC = " with magic dealing ";
    public static final String DEALT = " which dealt ";
    public static final String DAMAGE= " damage!";
    
    public static final String UP    = "up";
    public static final String DOWN  = "down";
    public static final String LEFT  = "left";
    public static final String RIGHT = "right";
    public static final String ENTER = "enter";
    public static final String SHIFT = "shift";
    public static final String ESCAPE= "escape";

    /**
     * Constructor for objects of class BattleField.
     * 
     */
    public BattleField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
}
