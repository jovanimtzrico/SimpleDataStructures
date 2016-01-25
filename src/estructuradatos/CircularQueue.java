
package estructuradatos;

public class CircularQueue {

    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public CircularQueue(int s){
        maxSize = s;
        queArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int j) {
        if (getRear() == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public int remove(){
        int temp = getQueArray()[front++];
        if (getFront() == maxSize){
            front = 0;
        }
        nItems--;
        return temp;
    }

    public int peekFront(){
        return getQueArray()[getFront()];
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    public int[] getQueArray() {
        return queArray;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

}
