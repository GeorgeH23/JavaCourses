package DataStructures.eHeap;

import java.util.Arrays;

public class Heap {

    private Node[] heapArray;
    private int maxSize; // size of the array
    private int currentSize; // number of nodes in the array

    public Heap(int size) {
        this.maxSize = size;
        this.currentSize = 0;
        this.heapArray = new Node[maxSize]; // actually creates the array
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public int getSize() {
        return currentSize;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) { // array is full
            return false;
        }

        Node newNode = new Node(key); // create new node
        heapArray[currentSize] = newNode; // put the node at the next available slot in the heapArray

        trickleUp(currentSize);
        currentSize++;

        return true;
    }

    private void trickleUp(int index) {
        int parentIndex = (index - 1) / 2;
        Node nodeToInsert = heapArray[index];

        // loop as long as we haven't reached the root
        // and key of nodeToInsert's parent is less than the new node

        while ((index > 0) && (heapArray[parentIndex].getKey() < nodeToInsert.getKey())) {
            heapArray[index] = heapArray[parentIndex]; // move parent down
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2; // move up
        }
        heapArray[index] = nodeToInsert;
    }

    public Node remove() {
        Node root = heapArray[0];
        currentSize--;
        heapArray[currentSize] = heapArray[0];

        trickleDown(0);

        return root;
    }

    private void trickleDown(int index) {
        int largerChildIndex;
        Node top = heapArray[index]; // saving the last node into top variable

        // will run as long as index is not at the bottom row (at least one child)
        while (index < currentSize / 2) {
            int leftChildIndex = 2 * index + 1; // left child index position
            int rightChildIndex = 2 * index + 2; // right child index position

            // figure out which child is larger
            if ((rightChildIndex < currentSize) && (heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey())) {
                largerChildIndex = rightChildIndex;
            } else {
                largerChildIndex = leftChildIndex;
            }

            if (top.getKey() >= heapArray[largerChildIndex].getKey()) {
                // successfully made root the largest key
                break;
            }

            heapArray[index] = heapArray[largerChildIndex];
            index = largerChildIndex; // go down
        }
        heapArray[index] = top;
    }

    public void displayHeap() {
        System.out.println("Heap Array: ");
        for(int m = 0; m < currentSize; m++) {
            if(heapArray[m] != null) {
                System.out.print( heapArray[m].getKey() + " ");
            }
            System.out.println();

            int nBlanks = 32;
            int itemsPerRow = 1;
            int column = 0;
            int j = 0; // current item

            String dots = "...............................";
            System.out.println(dots+dots);
            while(currentSize > 0) {
                if(column == 0) {
                    for(int k = 0; k < nBlanks; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(heapArray[j].getKey());
                j++;
                if(j == currentSize) {
                    break;
                }

                column++;
                // end of row
                if(column == itemsPerRow) {
                    nBlanks = nBlanks/2; // half the blanks
                    itemsPerRow = itemsPerRow * 2;     // twice the items
                    column = 0;
                    System.out.println();
                } else {
                    for(int k=0; k<nBlanks*2; k++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("\n"+dots+dots);
        }
    }

    @Override
    public String toString() {
        for (Node node : heapArray) {
            System.out.println(node.getKey());
        }
        return "";
    }
}


























