package towerofhanoi;
import java.util.EmptyStackException;
import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  Test class for linkedstacktest class
 * 
 *  @author jasminevarma23
 *  @version Mar 18, 2024
 */
public class LinkedStackTest
    extends TestCase
{
    private LinkedStack<String> stack;
    private LinkedStack<String> empty;


    private String hp = "Harry Potter";
    private String pj = "Percy Jackson";
    private String ot = "Oliver Twist";
    private String lw = "Little Women";
    
    //~ Fields ................................................................
    
    /**
     * setUp()
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
        empty = new LinkedStack<String>();

        stack.push(hp);
        stack.push(pj);
        stack.push(ot);
        stack.push(lw);
    }
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

    /**
     * test for toString()
     */
    public void testToString()
    {
        assertEquals(stack.toString(), "[Little Women, Oliver Twist, "
            + "Percy Jackson, Harry Potter]");
    }
    /**
     * test for isEmpty()
     */
    public void testIsEmpty()
    {
        assertFalse(stack.isEmpty());

        assertTrue(empty.isEmpty());
    }
    
    /**
     * test for peek()
     */
    public void testPeek()
    {
        Exception thrown = null;
        try 
        {
            empty.peek();
        } 
        catch (Exception exception) 
        {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);

        assertEquals(stack.peek(), "Little Women");
    }
    
    /**
     * test for pop()
     */
    public void testPop()
    {
        Exception thrown = null;
        try 
        {
            empty.pop();
        } 
        catch (Exception exception) 
        {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyStackException);

        assertEquals(stack.pop(), "Little Women");
    }
    
    /**
     * test for push()
     */
    public void testPush()
    {
        stack.push("Geronimo");
        assertEquals(stack.peek(), "Geronimo");

        empty.push("Geronimo");
        assertEquals(empty.peek(), "Geronimo");
        
    }
    
    /**
     * test for size()
     */
    public void testSize() 
    {
        assertEquals(stack.size(), 4);
    }
    
    /**
     * test for clear()
     */
    public void testClear()
    {
        stack.clear();
        assertEquals(stack.size(), 0);
    }
}
