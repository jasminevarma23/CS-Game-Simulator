package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2024
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Jasmine Varma (jasminevarma23)

// -------------------------------------------------------------------------
/**
 *  implements StackInterface<T>
 * 
 *  @author jasminevarma23
 *  @version February 28, 2024
 *  @param <T> 
 */
public class LinkedStack<T>
    implements StackInterface<T>
{
    private int size;
    private Node<T> topNode;
    // ----------------------------------------------------------
    /**
     * Create a new LinkedStack object.
     */
    public LinkedStack()
    {
        topNode = null;
    }


    // ----------------------------------------------------------
    /**
     * empties the stack
     */
    @Override
    public void clear()
    {
        this.topNode = null;
        this.size = 0;
    }


    // ----------------------------------------------------------
    /**
     * returns true or false if empty or not
     * @return true or false
     */
    @Override
    public boolean isEmpty()
    {
        return this.size == 0;
    }


    // ----------------------------------------------------------
    /**
     * looks at top item in stack
     * @return top item in stack
     */
    @Override
    public T peek()
    {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }
        return this.topNode.getData();

    }


    // ----------------------------------------------------------
    /**
     *  removes and returns the top item in the stack
     *  @return the data of the top item
     */
    @Override
    public T pop()
    {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }

        Node<T> temp = this.topNode;
        this.topNode = temp.getNextNode();
        size--;
        return temp.getData();
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T anEntry)
    {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        this.topNode = newNode;
        size++;
    }

    /**
     * getter for size
     * @return the size
     */
    public int size()
    {
        return this.size;
    }

    /**
     * toString for stack
     * @return a string of all stack items concatenated
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(topNode.getData()));
            topNode = topNode.getNextNode();
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     *  Node class
     * 
     *  @author jasminevarma23
     *  @version February 28, 2024
     *  @param <T>
     */
    private class Node<T>
    {
        private T data;
        private Node<T> next;
        
        /*
         * // ----------------------------------------------------------
        /**
         * Create a new Node object.
         * @param data
         */
        public Node(T data) 
        { 
            //this.next = null;
            this.data = data; 
        }

        /*
         * // ----------------------------------------------------------
        /**
         * Create a new Node object.
         * @param entry
         * @param node
         */
        public Node(T entry, Node<T> node) 
        { 
            this(entry); 
            this.setNextNode(node); 
        }

        
        /*
         * // ----------------------------------------------------------
        /**
         * sets next node to parameter
         * @param node
         */
        public void setNextNode(Node<T> node)
        {
            this.next = node;
        }

        /*
         * // ----------------------------------------------------------
        /**
         * getter for next node
         * @return the next node
         */
        public Node<T> getNextNode()
        {
            return this.next;
        }

        /*
         * // ----------------------------------------------------------
        /**
         * getter for data
         * @return the data
         */
        public T getData() 
        {
            return this.data;
        }
    }
}
