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
    private GreenfootImage credits1;
    private int creditPage = -1;

    /**
     * Constructor for objects of class Credits
     */
    public Credits(String path)
    {
        super(12, 8, 50);
        // don't construct anything yo... or maybe do?;
        Matcher matcher = Pattern.compile("\\d+").matcher(path);
        matcher.find();
        creditPage = Integer.valueOf(matcher.group());
        System.out.println("before: " + path);
        setBackground(path);
        System.out.println("after");
        //System.out.println(creditPage);
        rollCredits();
    }
    
    /**
     * Actually display the credits.
     */
    private void rollCredits()
    {
        String nextPage = "images/credits/credits" + (creditPage + 1) + ".png";
        System.out.println(nextPage);
        //this.setBackground(credits1);
        /*try
        {
            Thread.sleep(5000, 0);
        }
        catch (Exception e)
        {
        }*/
        //System.out.println(getBackground().toString());
        System.out.println(creditPage + " before entering");
        Greenfoot.delay(50);
        if(creditPage < 2) {
            System.out.println(creditPage + " after entering");
            Greenfoot.setWorld(new Credits(nextPage));
        }
        else {
            Greenfoot.stop();
        }
        //this.getWorld().setBackground(credits2);
        //System.out.println(getBackground().toString());
        //Greenfoot.delay(100);
        //this.setBackground(credits1);
    }
}

//super(600, 400, 1);