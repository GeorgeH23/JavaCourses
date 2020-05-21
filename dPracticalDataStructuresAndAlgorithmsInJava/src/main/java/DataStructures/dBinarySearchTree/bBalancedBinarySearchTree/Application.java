package DataStructures.dBinarySearchTree.bBalancedBinarySearchTree;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of SelfBalancingBinarySearchTree */
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("SelfBalancingBinarySearchTree Test\n");
        char ch;
        /*  Perform tree operations  */
        while (true) {
            System.out.println("\nSelfBalancingBinarySearchTree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear tree");
            System.out.println("6. Quit (Y/N)");

            String choice = scan.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter integer element to insert");
                    bst.insert(scan.nextInt());
                    break;
                case "2":
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : " + bst.search(scan.nextInt()));
                    break;
                case "3":
                    System.out.println("Nodes = " + bst.countNodes());
                    break;
                case "4":
                    System.out.println("Empty status = " + bst.isEmpty());
                    break;
                case "5":
                    System.out.println("\nTree Cleared");
                    bst.clear();
                    break;
                case "6":
                    System.out.println("\nDo you really want to quit?");
                    ch = scan.nextLine().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display tree  */
            System.out.print("\nPost order : ");
            bst.postOrder();
            System.out.print("\nPre order : ");
            bst.preOrder();
            System.out.print("\nIn order : ");
            bst.inorder();
            System.out.print("\nDisplay tree : ");
            bst.displayTree(bst.getRoot());
        }
    }
}
