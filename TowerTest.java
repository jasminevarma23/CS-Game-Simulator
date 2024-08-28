package towerofhanoi;
import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  Test class for Tower
 * 
 *  @author jasminevarma23
 *  @version Mar 18, 2024
 */
public class TowerTest
    extends TestCase
{   
    private Tower to;

    // ----------------------------------------------------------
    /**
     * Create a new TowerTest object.
     */
    public TowerTest()
    {
        // TODO Auto-generated constructor stub
    }
    //~ Fields ................................................................
    
    /**
     * setUp()
     */
    public void setUp()
    {
        to = new Tower(Position.LEFT);
    }
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    
    /**
     * test case for position()
     */
    public void testPosition()
    {
        assertEquals(to.position(), Position.LEFT);
    }
    
    /**
     * test case for push()
     */
    public void testPush()
    {
        Disk disk = null;
        Exception thrown = null;
        try 
        {
            to.push(disk);
        } 
        catch (Exception exception) 
        {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);
        
        to.push(new Disk(10));
        
        Exception thro = null;
        try 
        {
            to.push(new Disk(20));
            to.push(new Disk(10));
        } 
        catch (Exception exception) 
        {
            thro = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thro);

        // checks whether the right type of Exception was thrown
        assertTrue(thro instanceof IllegalStateException);
        
        Disk valid = new Disk(5);
        to.push(valid);
        assertEquals(valid, to.peek());
        
    }
    
    
}
