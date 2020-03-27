package DataStructures.cLinkedListDataStructure.dDoublyLinkedList;

public class DoublyLinkedList {

    private Node first;
    private Node last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (isEmpty()) {
            last = newNode; // if empty, last will refer to the new Node being created
        } else {
            first.previous = newNode;
        }
        newNode.next = first; // the new node's next field will point to the old first
        first = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode; // assigning old last to newNode
            newNode.previous = last; // the old last will be the newNode's previous
        }
        last = newNode; // the linkedList's last field should point to the new node
    }

    public Node deleteFirst() {
        if (!isEmpty()) {
            Node temp = first;
            if (first.next == null) {
                last = null;
            } else {
                first.next.previous = null;
            }
            first = first.next;
            return temp;
        }
        return null;
    }

    public Node deleteLast() {
        if (!isEmpty()) {
            Node temp = last;
            if (first.next == null) {
                first = null;
            } else {
                last.previous.next = null;
            }
            last = last.previous;
            return temp;
        }
        return null;
    }

    public boolean insertAfter(int key, int data) {
        if (!isEmpty()) {
            Node current = first;
            while (current.data != key) {
                current = current.next;
                if (current == null) {
                    return false;
                }
            }

            Node newNode = new Node();
            newNode.data = data;

            if (current == last) {
                current.next = null;
                last = newNode;
            } else {
                newNode.next = current.next;
                current.next.previous = newNode;
            }

            newNode.previous = current;
            current.next = newNode;

            return true;
        }
        return false;
    }

    public Node deleteKey(int key) {
        if (!isEmpty()) {
            Node current = first;
            while (current.data != key) {
                current = current.next;
                if (current == null) {
                    return null;
                }
            }

            if (current == first) {
                first = current.next;
            } else {
                current.previous.next = current.next;
            }

            if (current == last) {
                last = current.previous;
            } else {
                current.next.previous = current.previous;
            }
            return current;
        }
        return null;
    }

    public void displayForward() {
        System.out.println("List (first --> last) ");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.println("List (first --> last) ");
        Node current = last;
        while (current != null) {
            current.displayNode();
            current = current.previous;
        }
        System.out.println();
    }
}
