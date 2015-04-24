import greenfoot.*;

/**
 * Write a description of class ForestMap1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestMap1 extends World
{

    /**
     * Constructor for objects of class ForestMap1.
     * 
     */
    public ForestMap1()
    {    
        // Create a new world with 12x8 cells with a cell size of 50x50 pixels.
        super(12, 8, 50);
        addObject(new Character(), 300, 200);
        Greenfoot.delay(15);
    }
}
