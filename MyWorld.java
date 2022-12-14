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
    public int lives = 3;
    Label scoreLabel;
    Label lifeCounter;
    public int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        scoreLabel = new Label(0, 80);
        lifeCounter = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        addObject(lifeCounter, 550, 50);
        lifeCounter.setValue(lives);
        createApple();
    }
    /**
     * Ends the game and draws a giant "GameOver" label on the screen
     */
    public void gameOver() {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 300);
    }
    /**
     * Increase the scoreboard every time the elephant eats an apple
     */
    public void increaseScore() {
        score++;
        scoreLabel.setValue(score);
        
        if(score%5==0) {
            level++;
        }
    }
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple() {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(1);
        addObject(apple, x, y);
    }
    public int getLives() {
        return lives;
    }
    public void lifeLost() {
        lives--;
        lifeCounter.setValue(lives);
    }
}
