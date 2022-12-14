import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates an apple that falls from the top of the screen to the bottom
 *
 * @author Jerry Xing
 * @version November 2022
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY()+2);
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) {
            world.lifeLost();
            if (world.getLives() <= 0) {
                world.gameOver();
                world.removeObject(this);
            }
            else {
                world.removeObject(this);
                world.createApple();
            }
        }
    }
}

