package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Jasmine Varma (jasminevarma23)
// -------------------------------------------------------------------------
/**
 *  The tower on which the disks are stored as stacks
 * 
 *  @author jasminevarma23
 *  @version February 28, 2024
 */
public class Tower
    extends LinkedStack<Disk>
{
    //~ Fields ................................................................
    private Position position;
    // ----------------------------------------------------------
    /**
     * Create a new Tower object.
     * @param position 
     */
    public Tower(Position position)
    {
        super();
        this.position = position;
    }
  
    /**
     * returns the position of the tower
     * @return position of tower
     */
    public Position position()
    {
        return this.position;
    }
    
    /**
     * pushes a new object to the stack
     * @param disk a new disk
     */
    @Override
    public void push(Disk disk)
    {
        if (disk == null)
        {
            throw new IllegalArgumentException();
        }
        if (!isEmpty() && disk.compareTo(peek()) >= 0)    
        {
            throw new IllegalStateException();
        }
        
        super.push(disk);
    }
}
