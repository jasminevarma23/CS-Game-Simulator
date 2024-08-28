package towerofhanoi;
import java.util.Observable;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Jasmine Varma (jasminevarma23)
// -------------------------------------------------------------------------
/**
 *  Represents a tower of Hanoi puzzle
 * 
 *  @author jasminevarma23
 *  @version March 4, 2024
 */
public class HanoiSolver
    extends Observable
{
    //~ Fields ................................................................

    private Tower left;
    private Tower right;
    private Tower middle;
    private int numDisks;
    // ----------------------------------------------------------
    /**
     * Create a new HanoiSolver object.
     * @param numDisk passes in the number of disks
     */
    public HanoiSolver(int numDisk)
    {
        this.numDisks = numDisk;
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }

    //~Public  Methods ........................................................
    
   
    /**
     * returns the number of disks on a tower
     * @return number of disks on a tower
     */
    public int disks()
    {
        return this.numDisks;
    }
    
    
    /**
     * gets a specified tower at a location
     * @param pos passes in a position
     * @return the tower of specified position
     */
    public Tower getTower(Position pos)
    {
        switch(pos)
        {
            case LEFT:
                return this.left;
            case RIGHT:
                return this.right;
            case MIDDLE:
                return this.middle;
            default:
                return this.middle;
        }
                
    }
    
    /**
     * toString method
     * @return a string with disk widths
     */
    public String toString()
    {
        
        StringBuilder string = new StringBuilder("");
        string.append(this.left.toString());
        string.append(this.middle.toString());
        string.append(this.right.toString());
     
        return string.toString();
    }
   
    /**
     * executes the specified move
     * @param src
     * @param destination
     */
    private void move(Tower src, Tower destination)
    {
        Disk mover = src.pop();
        destination.push(mover);
        setChanged();
        notifyObservers(destination.position());
    }
    
    
    /*
     * // ----------------------------------------------------------
    /**
     * Solves the tower puzzle
     * @param currentDisks the number of current disks
     * @param startPole the starting pole
     * @param tempPole the holding pole
     * @param endPole the ending pole
     */
    private void solveTowers(int currentDisks, Tower startPole, Tower tempPole, 
        Tower endPole)
    {
        if (currentDisks == 1)
        {
            this.move(startPole, endPole);
        }
        else 
        {
            this.solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            this.move(startPole, endPole);
            this.solveTowers(currentDisks - 1, tempPole, startPole, endPole);  
        }
    }
    
    /**
     * the initial call to the solveTowers method
     */
    public void solve()
    {
        this.solveTowers(numDisks, left, middle, right);
    }
    
}
