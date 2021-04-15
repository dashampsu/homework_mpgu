package BinarySearchTree;

public class BinarySearchTree {
    Node root = new Node();

    public BinarySearchTree(String key) {
        root.key = key;
    }

    public Node search(String key) {
        return searchRec(key, root);
    }

    public void insert(String key) {
        if (root == null) {
            root = new Node(key);
        }
    }

    public String getKey(Node node) {
        return node.key;
    }

    private static Node searchRec(String key, Node root) {
        String rootKey = root.key;
        if (rootKey.equals(key)) {
            return root;
        }

        if (rootKey.compareTo(key) < key.compareTo(rootKey)) {
            return searchRec(key, root.rightNode);
        }

        return searchRec(key, root.leftNode);
    }






    private static class Node {
        String key;
        Node parentNode;
        Node rightNode;
        Node leftNode;

        public Node() {
            parentNode = null;
            rightNode = null;
            leftNode = null;
            key = null;
        }

        public Node(String key) {
            parentNode = null;
            rightNode = null;
            leftNode = null;
            this.key = key;
        }
    }
}
