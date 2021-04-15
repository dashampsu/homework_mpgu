package BinarySearchTree;

public class Node {
    String key;
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
}
