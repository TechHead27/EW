import greenfoot.*;

/**
 * Dis be where da credits will be from.
 * Gon' be fade-in-fade-out.
 * 
 * @author James Thomas Gryder III
 * @version 04/28/2015
 */
public class Credits extends World
{
    // instance variables - replace the example below with your own
    private GreenfootImage credits1;
    private final GreenfootImage credits2;

    /**
     * Constructor for objects of class Credits
     */
    public Credits()
    {
        super(12, 8, 50);
        // don't construct anything yo... or maybe do?
        credits1 = new GreenfootImage("credits.png");
        credits2 = new GreenfootImage("credits2.png");
        rollCredits();
        
    }
    
    /**
     * Actually display the credits.
     */
    private void rollCredits()
    {
        this.setBackground(credits1);
        try{
        credits1.wait(50);
    }
    catch(Exception e) {
    }
        //this.setBackground(credits2);
        credits1 = new GreenfootImage("credits2.png");
        this.setBackground(credits1);
    }
}

//super(600, 400, 1);