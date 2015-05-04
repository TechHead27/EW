import greenfoot.*;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    GreenfootImage bar;
    public HealthBar(Character player)
    {
        super();
        setHealthImage(player);
        bar = new GreenfootImage(getHealthPath(player));
        bar.scale(150, 40);
        setImage(bar);
    }
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    /**
     * Adjust the healthbar image for the player.
     */
    public void setHealthImage(Character player)
    {
        bar = new GreenfootImage(getHealthPath(player));
        bar.scale(150, 40);
        setImage(bar);
    }
    
    /**
     * Get path for new health bar image.
     */
    public String getHealthPath(Character player)
    {
        int health = player.getHealthPercent();
        int barNum = -1;
        int temp;
        String newPath = "";
        
        temp = health % 4;
        if (temp == 0)
        {
            barNum = health;
        }
        else if (temp == 1)
        {
            barNum = health + 3;
        }
        else if (temp == 2)
        {
            barNum = health + 2;
        }
        else
        {
            barNum = health + 1;
        }
        
        newPath = "images/hpbar/hp_" + barNum + "%.png";
        return newPath;
        //this.setImage("images/hpbar/hp_" + health + "%.png");
    }
}
