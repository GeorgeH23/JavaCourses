package DataStructures.dBinarySearchTree.bBalancedBinarySearchTree;

public class Node {

    private Node left;
    private Node right;
    private int data;
    private int height;

    /* Constructor */
    public Node() {
        this.left = null;
        this.right = null;
        this.data = 0;
        this.height = 0;
    }

    /* Constructor */
    public Node(int n) {
        this.left = null;
        this.right = null;
        this.data = n;
        this.height = 0;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public int getHeight() {
        return height;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
