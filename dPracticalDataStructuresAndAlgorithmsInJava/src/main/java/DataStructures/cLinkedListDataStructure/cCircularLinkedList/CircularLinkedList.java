package DataStructures.cLinkedListDataStructure.cCircularLinkedList;

public class CircularLinkedList {

    private Node first;
    private Node last;

    public CircularLinkedList() {
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // insert at the beginning of the list
    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    public int deleteFirst() {
        int temp = first.data;
        if(first.next ==null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.println("List (first --> last) ");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void insertLast( int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode; // the next value of the last node will point to the new node
            last = newNode; // we make the new node we created to be the last one in the list
        }
    }
}
