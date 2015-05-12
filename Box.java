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
            image = new GreenfootImage("images/menus/battlemenu.png");
            image.scale(120,120);
            setImage(image);
        }
    }

    
}
