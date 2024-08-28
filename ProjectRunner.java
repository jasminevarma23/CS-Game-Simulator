package towerofhanoi;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author jasminevarma
 *  @version Mar 18, 2024
 */
public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Create a new ProjectRunner object.
     */
    public ProjectRunner()
    {
        // TODO Auto-generated constructor stub
    }
    //~ Fields ................................................................
    // ----------------------------------------------------------
    /**
     * main method
     * @param args passes in a string arg
     */
    public static void main(String[] args){
        int disks = 6;
        if(args.length == 1)
        {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver hanoi = new HanoiSolver(disks);
        PuzzleWindow window = new PuzzleWindow(hanoi);
        
    }
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
