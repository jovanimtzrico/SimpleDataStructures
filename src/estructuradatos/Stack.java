/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos;

/**
 *
 * @author Jovani
 */
public class Stack {

    private int maxSize;        // size of stack array
    private int[] stackArray;
    private int top;            // top of stack
//-------------------------------------------------------------

    public Stack(int s) // constructor
    {
        maxSize = s;             // set array size
        stackArray = new int[maxSize];  // create array
        top = -1;                // no items yet
    }
//-------------------------------------------------------------

    public void push(int j) // put item on top of stack
    {
        stackArray[++top] = j;   // increment top, insert item
    }
//-------------------------------------------------------------

    public int pop() // take item from top of stack
    {
        return getStackArray()[top--]; // access item, decrement top
    }
//-------------------------------------------------------------

    public int peek() // peek at top of stack
    {
        return getStackArray()[getTop()];
    }
//-------------------------------------------------------------

    public boolean isEmpty() // true if stack is empty
    {
        return (getTop() == -1);
    }
//-------------------------------------------------------------

    public boolean isFull() // true if stack is full
    {
        return (getTop() == maxSize - 1);
    }

    /**
     * @return the stackArray
     */
    public int[] getStackArray() {
        return stackArray;
    }

    /**
     * @return the top
     */
    public int getTop() {
        return top;
    }
}
