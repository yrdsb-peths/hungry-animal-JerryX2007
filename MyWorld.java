import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Basic world for the Elephant
 *
 * @author Jerry Xing
 * @version November 2022
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 200);
        Label scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        createApple();
    }
    /**
     * Increase the scoreboard every time the elephant eats an apple
     */
    public void increaseScore() {
        score++;
        scoreLabel.setValue(score);
    }
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple() {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(1);
        addObject(apple, x, y);
    }
}
