import greenfoot.*;
import java.util.regex.*;

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
    private GreenfootImage credits;
    private int creditPage = -1;

    /**
     * Constructor for objects of class Credits
     */
    public Credits(String path)
    {
        super(4, 4, 100);
        // don't construct anything yo... or maybe do?;
        Matcher matcher = Pattern.compile("\\d+").matcher(path);
        matcher.find();
        creditPage = Integer.valueOf(matcher.group());
        
        setBackground(path);
    }
    
    /**
     * Change the pictures yo
     */
    public void act() {
        String nextPage = "images/credits/credits" + (creditPage + 1) + ".png";

        if(creditPage++ < 2) {
            Greenfoot.delay(200);
            setBackground(nextPage);
        }
        else {
            Greenfoot.stop();
        }
    }
}