package towerofhanoi;

import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  test class for disk
 * 
 *  @author jasminevarma23
 *  @version Mar 18, 2024
 */
public class DiskTest
    extends TestCase
{

    
    private Disk disk;
    private Disk disk1;
    //~ Constructors ..........................................................
    
    /**
     * setUp() method
     */
    public void setUp()
    {
        disk = new Disk(30);
        disk1 = new Disk(20);
    }
    //~Public  Methods ........................................................
    
    /**
     * test case for compareTo
     */
    public void testCompareTo()
    {
        Disk disk4 = null;
        Exception thrown = null;
        try 
        {
            disk.compareTo(disk4);
        } 
        catch (Exception exception) 
        {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals(disk.compareTo(disk1), 10);
        assertEquals(disk1.compareTo(disk), -10);

    }
    
    /**
     * test case for toString()
     */
    public void testToString()
    {
        assertEquals(disk.toString(), "30");
    }
    
    /**
     * test case for equals()`  
     */
    public void testEquals()
    {
        Disk disk3 = new Disk(30);
        Disk disk4 = new Disk(20);
        Disk disk5 = null;
        assertEquals(disk, disk3);
        assertFalse(disk3.equals(disk4));
        assertFalse(disk3.equals("disk"));
        assertFalse(disk3.equals(null));
        assertEquals(disk, disk);
        assertFalse(disk.equals(disk5));
    }
}
