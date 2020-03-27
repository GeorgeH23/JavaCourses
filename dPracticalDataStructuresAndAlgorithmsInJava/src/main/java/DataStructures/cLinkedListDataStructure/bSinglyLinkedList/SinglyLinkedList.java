package DataStructures.cLinkedListDataStructure.bSinglyLinkedList;

public class SinglyLinkedList {

    private Node first;

    public SinglyLinkedList() {
    }

    public boolean isEmpty() {
        return (first == null);
    }

    // insert at the beginning of the list
    public void insertFirst(int data) {
        if (isEmpty()) {
            first = new Node();
            first.data = data;
        } else {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = first;
            first = newNode;
        }
    }

    public Node deleteFirst() {
        Node temp = first;
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
        Node current = first;
        while (current.next != null) {
            current = current.next; // will loop until current.next is null
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }
}
