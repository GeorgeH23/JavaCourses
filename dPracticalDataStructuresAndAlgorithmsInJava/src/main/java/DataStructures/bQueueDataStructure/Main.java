package DataStructures.bQueueDataStructure;

public class Main {

    public static void main(String[] args) {

        Queue myQueue = new Queue(5);

        myQueue.insert(100);
        myQueue.insert(1000);
        myQueue.insert(14);
        myQueue.insert(12);
        myQueue.insert(44);
        myQueue.insert(12);
        myQueue.view();
        System.out.println(myQueue);

        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.remove());
        }
    }
}
