import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author Jerry Xing
 * @version December 2022
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 80 );

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, 50);
        prepare();
    }

    public void act() {
        if(Greenfoot.isKeyDown("space")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,292,208);
        elephant.setLocation(298,140);
        Label label = new Label("Use \u2190 \u2192 to move", 40);
        addObject(label,272,233);
        label.setLocation(331,221);
        Label label2 = new Label("Press <space> to start", 40);
        addObject(label2,276,303);
        label.setLocation(300,220);
        label2.setLocation(300,300);
    }
}
