package BinarySearchTree;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = new Node();
    }

    public BinarySearchTree(String key) {
        root = new Node(key);
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
                focusNode.rightNode.parentNode = focusNode;
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
                focusNode.leftNode.parentNode = focusNode;
            } else {
                // if the left child does exist
                insertRec(key, focusNode.leftNode);
            }
        }
    }

    public void printAll() {
        printAllRec(root);
    }

    private static void printAllRec(Node focusNode){
        if (focusNode == null) {
            return;
        }

        System.out.println(focusNode.key);
        Node nextNode = getSuccessor(focusNode);
        printAllRec(nextNode);
    }

    private static Node getSuccessor(Node focusNode) {
        if (nodeExists(focusNode, "right")) {
            focusNode = focusNode.rightNode;
            while (focusNode.leftNode != null) {
                focusNode = focusNode.leftNode;
            }
            return focusNode;
        } else {
            // if the right node doesn't exist
            while (nodeExists(focusNode, "parent")) {
                Node focusNodeParent = focusNode.parentNode;
                if (focusNodeParent.leftNode == focusNode) {
                    // if parent element has a left child
                    // and this left child is the focus node
                    return focusNodeParent;
                } else {
                    focusNode = focusNodeParent;
                }
            }
            return null;
        }
    }

    private static boolean nodeExists(Node focusNode, String whatNode) {
        boolean doesExist;

        if (whatNode.equals("right")) {
            try {
                // if rightNode exists, returns true
                doesExist = focusNode.rightNode != null;
            } catch (Exception NullPointerException) {
                doesExist = false;
            }

            return doesExist;
        }

        else if (whatNode.equals("left")) {
            try {
                // if leftNode exists, returns true
                doesExist = focusNode.leftNode != null;
            } catch (Exception NullPointerException) {
                doesExist = false;
            }
            return doesExist;
        }

        else if (whatNode.equals("parent")) {
            try {
                // if parentNode exists, returns true
                doesExist = focusNode.parentNode != null;
            } catch (Exception NullPointerException) {
                doesExist = false;
            }
            return doesExist;
        }

        else {
            throw new RuntimeException("wrong node name");
        }
    }
}