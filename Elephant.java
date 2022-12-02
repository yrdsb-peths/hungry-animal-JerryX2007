import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant for Hungry Elephant game
 *
 * @author Jerry Xing
 * @version 1.0 (updated 28/11/2022)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    GreenfootImage[] idleRight = new GreenfootImage[8];
    // Direction the elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Elephant constructor
     */
    public Elephant() {
        for(int i=0;i<8;i++) {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle"+i+".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i=0;i<idleLeft.length;i++) {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle"+i+".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        
        animationTimer.mark();
        
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant() {
        if(animationTimer.millisElapsed() < 200) {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")) {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("left")) {
            move(-5);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right")) {
            move(5);
            facing = "right";
        }
        // Remove apple if elephant eats it
        eat();
        //Animate elephant
        animateElephant();
    }
    /**
     * Eat the apple and spawn a new apple;
     */
    public void eat() {
        if(isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
