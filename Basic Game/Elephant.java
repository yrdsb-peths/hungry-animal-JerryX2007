import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant for Hungry Elephant game
 *
 * @author Jerry Xing
 * @version 1.0 (updated 28/11/2022)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantSound.mp3");
    public void act()
    {
        if(Greenfoot.isKeyDown("left")) {
            move(-5);
        }
        else if(Greenfoot.isKeyDown("right")) {
            move(5);
        }
        // Remove apple if elephant eats it
        eat();

    }
    /**
     * Eat the apple and spawn a new apple;
     */
    public void eat() {
        if(isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
        }
    }
}
