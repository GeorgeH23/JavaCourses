package DataStructures.dBinarySearchTree.aUnbalancedBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;

    public void insert(int key, String value) {

        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key <= current.getKey()) {
                    current = current.getLeftChild();
                    if (current == null) { // It's parent is the leaf node
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public Node findMin() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public Node findMax() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }

    public boolean remove(int key) {
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = false;

        // Searching to find the node with the key to delete
        while (currentNode.getKey() != key) {
            parentNode = currentNode;
            if (key < currentNode.getKey()) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
                isLeftChild = false;
            }
            if (currentNode == null) {
                return false;
            }
        }

        // At this point we've found the node we have to delete
        Node nodeToDelete = currentNode;

        // if node is a leaf
        if ((nodeToDelete.getLeftChild() == null) && (nodeToDelete.getRightChild() == null)) {
            if (nodeToDelete == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.setLeftChild(null);
            } else {
                parentNode.setRightChild(null);
            }
        } // if node has one child that is on the left
          else if (nodeToDelete.getRightChild() == null) {
              if (nodeToDelete == root) {
                  root = nodeToDelete.getLeftChild();
              } else if (isLeftChild) {
                  parentNode.setLeftChild(nodeToDelete.getLeftChild());
              } else {
                  parentNode.setRightChild(nodeToDelete.getLeftChild());
              }
        } // if node has one child that is on the left
          else if (nodeToDelete.getLeftChild() == null) {
            if (nodeToDelete == root) {
                root = nodeToDelete.getRightChild();
            } else if (isLeftChild) {
                parentNode.setLeftChild(nodeToDelete.getRightChild());
            } else {
                parentNode.setRightChild(nodeToDelete.getRightChild());
            }
        } // if node has two children (tricky)
          else {
              Node successor = getSuccessor(nodeToDelete);
              // Connect the parent of the nodeToDelete to successor instead
            if (nodeToDelete == root) {
                root = successor;
            } else if (isLeftChild) {
                parentNode.setLeftChild(successor);
            } else {
                parentNode.setRightChild(successor);
            }

            successor.setLeftChild(nodeToDelete.getLeftChild());
        }

        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {
        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;

        Node currentNode = nodeToDelete.getRightChild(); // go to the right child

        while (currentNode != null) { // start going left down the tree until node has no left child
            successorParent = successor;
            successor = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        // if successor is not a right child
        if (successor != nodeToDelete.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(nodeToDelete.getRightChild());
        }
        return successor;
    }

    public int maxDepth(Node node) {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.getLeftChild());
            int rDepth = maxDepth(node.getRightChild());

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
                    System.out.print(temp.getKey());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if(temp.getLeftChild() != null || temp.getRightChild() != null) {
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

    public void displayBST() {
        Node current = root;
        Queue<Node> queue = new LinkedList();
        queue.add(current);

        while (!queue.isEmpty()) {
            final Node peek = queue.remove();
            System.out.println(peek.getKey());
            if(peek.getLeftChild() != null) queue.add(peek.getLeftChild());
            if(peek.getRightChild() != null) queue.add(peek.getRightChild());
        }

    }

    public Node getRoot() {
        return root;
    }
}




















