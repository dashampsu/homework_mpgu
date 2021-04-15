package BinarySearchTree;

public class BinarySearchTree {
    Node root = new Node();

    public BinarySearchTree() {

    }

    public BinarySearchTree(String key) {
        root.key = key;
    }

    public void insert(String key) {
        if (root.key == null) {
            root = new Node(key);
            return;
        }

        insertRec(key, root);
    }

    private static void insertRec(String key, Node focusNode) {
        if (key.compareTo(focusNode.key) > 0) {
            // if the node is to be placed on the right
            // (if new key is greater than the focusNode key)

            if (focusNode.rightNode == null) {
                focusNode.rightNode = new Node(key);
                return;
            } else {
                // if the right child does exist
                insertRec(key, focusNode.rightNode);
            }
        }

        if (key.compareTo(focusNode.key) <= 0) {
            // if the node is to be placed on the left
            // (if new key is lesser than the focusNode key)

            if (focusNode.leftNode == null) {
                focusNode.leftNode = new Node(key);
                return;
            } else {
                // if the left child does exist
                insertRec(key, focusNode.leftNode);
            }
        }
    }
}
