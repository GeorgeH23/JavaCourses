package DataStructures.cLinkedListDataStructure.cCircularLinkedList;

public class App {

    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();
        myList.insertFirst(100);
        myList.insertFirst(50);
        myList.insertFirst(99);
        myList.insertFirst(88);
        myList.insertFirst(177);
        myList.insertFirst(69);

        myList.insertLast(11);
        myList.insertLast(12);
        myList.insertLast(13);

        myList.displayList();
    }
}
