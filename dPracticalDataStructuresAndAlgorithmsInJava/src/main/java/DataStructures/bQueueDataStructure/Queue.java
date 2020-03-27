package DataStructures.bQueueDataStructure;

public class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems; // number of items in the queue

    public Queue(int size) {
        this.maxSize = size;
        this.queArray = new long[size];
        this.front = 0; //index position of the first slot of the array
        this.rear = -1; //there is no item in the array yet to be considered as the last item
        this.nItems = 0; // we don't have elements in the array yet
    }

    public void insert(long j) {
        rear++;
        try {
            queArray[rear] = j;
            nItems++;
        } catch (IndexOutOfBoundsException e) {
            rear--;
            e.printStackTrace();
        }

    }

    public long remove() {
        long temp = queArray[front];
        front++;
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public void view() {
        System.out.print("[ ");
        for (long element : queArray) {
            System.out.print(element + " ");
        }
        System.out.println("]");
    }
}
