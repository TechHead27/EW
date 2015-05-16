import greenfoot.*;

/**
 * Write a description of class MenuItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuItem extends Actor
{
    public MenuItem(String path)
    {
        GreenfootImage button = new GreenfootImage(path);
        button.scale(200, 50);
        setImage(button);
    }
}
