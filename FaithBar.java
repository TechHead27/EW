import greenfoot.*;

/**
 * Write a description of class FaithBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FaithBar extends Actor
{
    GreenfootImage bar;
    public FaithBar(Character player)
    {
        super();
        setFaithImage(player);
        bar = new GreenfootImage(getFaithPath(player));
        bar.scale(180, 48);
        setImage(bar);
    }
    
    /**
     * Adjust the faithbar image for the player.
     */
    public void setFaithImage(Character player)
    {
        bar = new GreenfootImage(getFaithPath(player));
        bar.scale(180, 48);
        setImage(bar);
    }
    
    /**
     * Get path for new faith bar image.
     */
    public String getFaithPath(Character player)
    {
        int faith = player.getFaithPercent();
        int barNum = -1;
        int temp;
        String newPath = "";
        
        temp = faith % 4;
        if (temp == 0)
        {
            barNum = faith;
        }
        else if (temp == 1)
        {
            barNum = faith + 3;
        }
        else if (temp == 2)
        {
            barNum = faith + 2;
        }
        else
        {
            barNum = faith + 1;
        }
        
        newPath = "images/mpbar/mp_" + barNum + "%.png";
        return newPath;
    }
}
