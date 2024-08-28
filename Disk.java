package towerofhanoi;

import cs2.Shape;
import java.awt.Color;
import student.TestableRandom;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Jasmine Varma (jasminevarma23)
// -------------------------------------------------------------------------
/**
 *  implementation of comparable disk interface
 * 
 *  @author jasminevarma23
 *  @version February 26, 2024
 */
public class Disk  
    extends Shape
    implements Comparable<Disk>
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Create a new Disk object.
     * @param width passes a new width
     */
    public Disk(int width)
    {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom gen = new TestableRandom();
        int red = gen.nextInt(256);
        int blue = gen.nextInt(256);
        int green = gen.nextInt(256);
        Color randColor = new Color(red, blue, green);
        this.setBackgroundColor(randColor);


    }

    //~Public  Methods ........................................................

    /**
     * For determining relative size of disks by comparing to other disks
     * @param other comparison disk
     * @return 1 if this >, -1 if this <, 0 if ==
     */
    @Override
    public int compareTo(Disk other)
    {
        if (other == null)
        {
            throw new IllegalArgumentException();
        }

        return this.getWidth() - other.getWidth();
    }

    /**
     * toString method
     * @return a string containing the width
     */
    @Override
    public String toString()
    {
        String par = this.getWidth() + "";
        return par;
    }

    /**
     * equals to method
     * @return equal or not
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == this) {
            return true;
        }
        if ((other == null) || (other.getClass() != this.getClass())) {
            return false;
        }

        return this.getWidth() == ((Disk)other).getWidth();
    }

}
