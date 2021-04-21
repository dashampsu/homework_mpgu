package BinarySearchTree;

public class Node {
    String key;
    int height;
    Node parentNode;
    Node rightNode;
    Node leftNode;

    public Node() {
        key = null;
        parentNode = null;
        rightNode = null;
        leftNode = null;
    }

    public Node(String key) {
        this.key = key;
        parentNode = null;
        rightNode = null;
        leftNode = null;
    }

    public String getKey() {
        return key;
    }

    public Node getLeft() {
        return leftNode;
    }

    public Node getRight() {
        return rightNode;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public int getHeight() {
        if (leftNode == null & rightNode == null) {
            // if the node has no children

            return -1;
        }

        if (leftNode == null & rightNode != null) {
            // if the node only has one child (right one)

            return 0;
        }

        else if (leftNode != null & rightNode == null) {
            // if the node only has one child (left one)

            return 0;
        }

        if (leftNode != null & rightNode != null) {
            // if the node has 2 children

            return Math.max(leftNode.getHeight(), rightNode.getHeight()) + 1;
        }

        return -2;
    }
}
