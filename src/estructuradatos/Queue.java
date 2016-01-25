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
public class Queue {

    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;
//-------------------------------------------------------------

    public Queue(int s) // constructor
    {
        maxSize = s;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    //-------------------------------------------------------------

    public void insert(int j) {
        if (getRear() == maxSize - 1) {
            rear = -1;
        }
        // put item at rear of queue
        // deal with wraparound
        // increment rear and
        // one more item
        queArray[++rear] = j;
        nItems++;
    }

    public int remove() // take item from front of queue
    {
        int temp = getQueArray()[front++]; // get value and incr front
        if (getFront() == maxSize) // deal with wraparound
        {
            front = 0;
        }
        nItems--;                     // one less item
        return temp;
    }

    public int peekFront() // peek at front of queue
    {

        return getQueArray()[getFront()];
    }
//-------------------------------------------------------------

    public boolean isEmpty() // true if queue is empty
    {
        return (nItems == 0);
    }
//-------------------------------------------------------------

    public boolean isFull() // true if queue is full
    {
        return (nItems == maxSize);
    }

    public int size() // number of items in queue
    {
        return nItems;
    }

    /**
     * @return the queArray
     */
    public int[] getQueArray() {
        return queArray;
    }

    /**
     * @return the front
     */
    public int getFront() {
        return front;
    }

    /**
     * @return the rear
     */
    public int getRear() {
        return rear;
    }
    
}
