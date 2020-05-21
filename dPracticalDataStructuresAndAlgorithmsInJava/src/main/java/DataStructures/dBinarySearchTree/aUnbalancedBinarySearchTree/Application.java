package DataStructures.dBinarySearchTree.aUnbalancedBinarySearchTree;

public class Application {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10, "Ten");
        tree.insert(20, "Twenty");
        tree.insert(4, "Four");
        tree.insert(2, "Two");
        tree.insert(5, "Five");
        tree.insert(10,"Ten");
        tree.insert(10,"Ten");
        tree.insert(20,"Twenty");
        tree.insert(20,"Twenty");
        tree.insert(20,"Twenty");
        //tree.insert(8, "Eight");
        //tree.insert(9, "Nine");
        /*tree.insert(18, "Eighteen");
        tree.insert(19, "Nineteen");
        tree.insert(17, "Seventeen");
        tree.insert(22, "Twenty Two");
        tree.insert(21, "Twenty One");
        tree.insert(24, "Twenty Four");*/
        //tree.insert(33, "Thirty Three");

        //tree.insert(101, "Ten");
        /*tree.insert(202, "Twenty");*/
        //tree.insert(42, "Four");
        //tree.insert(21, "Two");
        //tree.insert(53, "Five");
        //tree.insert(84, "Eight");
        //tree.insert(95, "Nine");
        //tree.insert(181, "Eighteen");
        //tree.insert(192, "Nineteen");
        //tree.insert(171, "Seventeen");
        //tree.insert(224, "Twenty Two");
        //tree.insert(215, "Twenty One");
        //tree.insert(243, "Twenty Four");
        //tree.insert(333, "Thirty Three");

        /*tree.insert(10, "Ten");
        tree.insert(20, "Twenty");
        tree.insert(4, "Four");
        tree.insert(2, "Two");
        tree.insert(5, "Five");
        tree.insert(8, "Eight");*/
        //tree.insert(9, "Nine");
        /*tree.insert(18, "Eighteen");
        tree.insert(19, "Nineteen");
        tree.insert(17, "Seventeen");
        tree.insert(22, "Twenty Two");
        tree.insert(21, "Twenty One");*/
        //tree.insert(24, "Twenty Four");
        //tree.insert(33, "Thirty Three");

        /*tree.displayTree(tree.getRoot());
        tree.displayTree(tree.getRoot().getRightChild());*/
        System.out.println(tree.maxDepth(tree.getRoot()));

        tree.displayTree(tree.getRoot());

        System.out.println(tree.findMin().getKey());
        System.out.println(tree.findMax().getKey());

        System.out.println(tree.remove(22));
        tree.displayTree(tree.getRoot());
        System.out.println(tree.findMin().getKey());

    }
}
