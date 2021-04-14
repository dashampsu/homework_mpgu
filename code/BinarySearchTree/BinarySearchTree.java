package BinarySearchTree;

public class BinarySearchTree {
    Node root;

    public Node search(String key) {
        return searchRec(key, root);
    }

    private static Node searchRec(String key, Node root) {
        return root;
    }

    private class Node {
        String data;
        Node parentNode;
        Node rightNode;
        Node leftNode;
    }
}
