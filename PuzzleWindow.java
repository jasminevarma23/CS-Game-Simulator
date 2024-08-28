package towerofhanoi;
// Virginia Tech Honor Code Pledge:
//
// Project 3
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Jasmine Varma (jasminevarma23)

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
/**
 * The main front-end work and the view for the Tower of Hanoi puzzle
 *
 * @author  Jasmine Varma
 * @version March 5 2024
 */
public class PuzzleWindow implements Observer 
{
    //~ Fields ..............................................................

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    /**
     * A factor in which the width of the disks are multiplied by
     */
    public static final int WIDTH_FACTOR = 15;
    /**
     * The vertical gap between each disk on the tower
     */
    public static final int DISK_GAP = 0;
    /**
     * The height of each disk on the tower
     */
    public static final int DISK_HEIGHT = 15;
    /**
     * Creates a new PuzzleWindow view for a given HanoiSolver game
     *
     * @param g the game to create a view for
     */
    public PuzzleWindow(HanoiSolver g) 
    {
        this.game = g;
        this.game.addObserver(this);
        this.window = new Window("Tower of Hanoi");
        this.window.setSize(700, 500);

        //The height and Y location of each pole are the same
        int poleHeight = 200;
        int poleY = (window.getGraphPanelHeight() / 2) - (poleHeight / 2);
        left = new Shape((200 - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        middle = new Shape(((window.getGraphPanelWidth() / 2) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));
        right = new Shape(((window.getGraphPanelWidth() - 200) - 15 / 2),
            poleY, 15, poleHeight, new Color(50, 50, 50));


        for (int width = (game.disks() + 1) * WIDTH_FACTOR;
            width > WIDTH_FACTOR;
            width -= WIDTH_FACTOR)
        {
            Disk di = new Disk(width);
            this.window.addShape(di);

            this.game.getTower(Position.LEFT).push(di);

            moveDisk(Position.LEFT);
        }

        this.window.addShape(this.left);
        this.window.addShape(this.middle);
        this.window.addShape(this.right);

        Button solve =  new Button("Solve");
        this.window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }


    /**
     * Updates the view whenever a disk is moved in the back-end
     *
     * @param o The observable that triggered the update
     * @param arg arguments sent by the game; should be a position
     */
    @Override
    public void update(Observable o, Object arg) 
    {
        if (arg.getClass() == Position.class) {
            Position position = (Position)arg;
            moveDisk(position);
            sleep();
        }
    }
    private void sleep() 
    {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
            //empty block
        }
    }
    /**
     * Runs when the Solve button is clicked, tells the puzzle to start solving
     *
     * @param button the button that was clicked
     */
    public void clickedSolve(Button button) 
    {
        button.disable();
        new Thread() 
        {
            public void run() 
            {
                game.solve();
            }
        }
        .start();
    }
/*
 * // ----------------------------------------------------------
/**
 * Updates the front end after the back end has been changed
 * @param position passes in a position object
 */
    private void moveDisk(Position position) 
    {
        Disk currentDisk = this.game.getTower(position).peek();
        Shape currentPole = null;

        switch (position)
        {
            case LEFT:
                currentPole = this.left;
                break;
            case RIGHT:
                currentPole = this.right;
                break;

            case MIDDLE:
                currentPole = this.middle;
                break;
            default:
                currentPole = this.middle;
                break;
        }

        int xcoord = currentPole.getX() - ((currentDisk.getWidth() - 15) / 2);
        int ycoord = currentPole.getY() + 200 - 
            (this.game.getTower(position).size() * currentDisk.getHeight());

        currentDisk.moveTo(xcoord, ycoord);

    }
}
