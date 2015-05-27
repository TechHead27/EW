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
    public static String WRECK = "Attack ";
    public static String REKT  = "Attacked by ";
    public static String DEAD  = "You died!";
    public static String WIN   = " defeated!";
    public static String RECOV = "Recovered ";
    public static String FAITH = " faith!";
    public static String HEALTH= " health!";
    public static String RUNYES= "Escape success!";
    public static String RUNNO = "Escape failed!";
    public static String CHEAT = "Cheater!";
    public static String NOMP  = "Not enough faith!";
    
    public static String FISTS = " with fists dealing ";
    public static String MAGIC = " with magic dealing ";
    public static String DEALT = " which dealt ";
    public static String DAMAGE= " damage!";
    
    public static String UP    = "up";
    public static String DOWN  = "down";
    public static String LEFT  = "left";
    public static String RIGHT = "right";
    public static String ENTER = "enter";
    public static String SHIFT = "shift";
    public static String ESCAPE= "escape";

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
