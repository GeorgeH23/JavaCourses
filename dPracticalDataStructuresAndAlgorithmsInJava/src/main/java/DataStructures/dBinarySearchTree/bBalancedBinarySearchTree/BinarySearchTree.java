package DataStructures.dBinarySearchTree.bBalancedBinarySearchTree;

import java.util.Stack;

public class BinarySearchTree {

    private Node root;

    /* Constructor */
    public BinarySearchTree() {
        this.root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Make the tree logically empty */
    public void clear() {
        root = null;
    }

    /* Function to insert data */
    public void insert(int data) {
        root = insert(data, root);
    }

    /* Function to get height of node */
    private int height(Node t) {
        return t == null ? -1 : t.getHeight();
    }

    /* Function to max of left/right node */
    private int max(int lhs, int rhs) {
        return Math.max(lhs, rhs);
    }

    /* Function to insert data recursively */
    private Node insert(int x, Node t) {
        if (t == null)
            t = new Node(x);
        else if (x < t.getData()) {
            t.setLeft(insert(x, t.getLeft()));
            if (height(t.getLeft()) - height(t.getRight()) == 2)
                if (x < t.getLeft().getData())
                    t = rotateWithLeftChild(t);
                else
                    t = doubleWithLeftChild(t);
        } else if (x > t.getData()) {
            t.setRight(insert(x, t.getRight()));
            if (height(t.getRight()) - height(t.getLeft()) == 2)
                if (x > t.getRight().getData())
                    t = rotateWithRightChild(t);
                else
                    t = doubleWithRightChild(t);
        } else
            ;  // Duplicate; do nothing
        t.setHeight(max(height(t.getLeft()), height(t.getRight())) + 1);
        return t;
    }

    /* Rotate binary tree node with left child */
    private Node rotateWithLeftChild(Node k2) {
        Node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(max(height(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }

    /* Rotate binary tree node with right child */
    private Node rotateWithRightChild(Node k1) {
        Node k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(max(height(k1.getLeft()), height(k1.getRight())) + 1);
        k2.setHeight(max(height(k2.getRight()), k1.getHeight()) + 1);
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child
     */
    private Node doubleWithLeftChild(Node k3) {
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child
     */
    private Node doubleWithRightChild(Node k1) {
        k1.setRight(rotateWithLeftChild(k1.getRight()));
        return rotateWithRightChild(k1);
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(Node r, int val) {
        boolean found = false;
        while ((r != null) && !found) {
            int rVal = r.getData();
            if (val < rVal)
                r = r.getLeft();
            else if (val > rVal)
                r = r.getRight();
            else {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node r) {
        if (r != null) {
            System.out.print(r.getData() + " ");
            preOrder(r.getLeft());
            preOrder(r.getRight());
        }
    }

    /* Function for postorder traversal */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node r) {
        if (r != null) {
            postOrder(r.getLeft());
            postOrder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }

    public int maxDepth(Node node) {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.getLeft());
            int rDepth = maxDepth(node.getRight());

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public void displayTree(Node node) {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(node);
        int maxDepth = maxDepth(node);
        System.out.println("Max depth is: " + maxDepth);
        int nBlanks = 32;
        if (maxDepth > 4) {
            int multiplier = maxDepth - 4;
            for (int i = 0; i < multiplier; i++) {
                nBlanks = nBlanks * 2;
            }
        }
        boolean isRowEmpty = false;
        System.out.println(".................................................." +
                "............................................................." +
                ".............................................................");

        while(!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }

            while(!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if(temp.getLeft() != null || temp.getRight() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();
            nBlanks = nBlanks/2;

            while(!localStack.isEmpty())
                globalStack.push( localStack.pop() );
        }
        System.out.println(".................................................." +
                "............................................................." +
                ".............................................................");

    }

    public Node getRoot() {
        return root;
    }
}
