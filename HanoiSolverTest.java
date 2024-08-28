package towerofhanoi;
import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  test class for hanoisolver
 * 
 *  @author jasminevarma23
 *  @version Mar 18, 2024
 */
public class HanoiSolverTest
    extends TestCase
{
    private HanoiSolver hs;
    private Tower left;
    private Tower right;

    private Tower middle;
    
    /**
     * setUp() method
     */
    public void setUp()
    {
        hs = new HanoiSolver(3);
        left = hs.getTower(Position.LEFT);
        right = hs.getTower(Position.RIGHT);
        middle = hs.getTower(Position.MIDDLE);
            
    }
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    
    /**
     * testDisks()
     */
    public void testDisks()
    {
        assertEquals(hs.disks(), 3);
    }
    
    /**
     * test getTower()
     */
    public void testGetTower()
    {
       

        assertEquals(hs.getTower(Position.LEFT), left);
        assertEquals(hs.getTower(Position.RIGHT), right);
        assertEquals(hs.getTower(Position.MIDDLE), middle);


    }
    
    /**
     * test toString()
     */
    public void testToString()
    {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(15);
        Disk disk3 = new Disk(20);
        left.push(disk1);
        middle.push(disk2);
        right.push(disk3);

        assertEquals(hs.toString(), "[5][15][20]");
    }
    
    /**
     * test case for solve()
     */
    public void testSolve()
    {
        Disk disk4 = new Disk(5);
        Disk disk5 = new Disk(4);
        Disk disk6 = new Disk(3);
  
        left.push(disk4);
        left.push(disk5);
        left.push(disk6);

        hs.solve();
        assertEquals(hs.toString(), "[][][3, 4, 5]");
    }
}
