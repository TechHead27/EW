import greenfoot.*;

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    /**
     * Constructor for objects of class Box
     */
    public Box(boolean forCollision)
    {
        GreenfootImage image;
        if (forCollision)
        {
            // make the box invisible
        }
        else
        {
            // use the image to wrap the monster
            image = new GreenfootImage("images/hitBox.png");
            image.scale(105,105);
            setImage(image);
        }
    }
    
    /**
     * surround enemies
     * enemy1 - 390, 60
     * enemy2 - 520, 110
     * enemy3 - 390, 180
     */

    
}
