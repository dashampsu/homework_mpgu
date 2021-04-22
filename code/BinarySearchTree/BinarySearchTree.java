package BinarySearchTree;

import java.util.Objects;

public class BinarySearchTree {
    public Node root;

    public static final String not_found = "The item is not found";

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
        balance(Objects.requireNonNull(insertRec(key, root)).parentNode);
    }

    private static Node insertRec(String key, Node focusNode) {
        if (key.compareTo(focusNode.key) > 0) {
            // if the node is to be placed on the right
            // (if new key is greater than the focusNode key)

            if (focusNode.rightNode == null) {
                focusNode.rightNode = new Node(key);
                focusNode.rightNode.parentNode = focusNode;
                return focusNode.rightNode;
            } else {
                // if the right child does exist
                return insertRec(key, focusNode.rightNode);
            }
        }

        else if (key.compareTo(focusNode.key) <= 0) {
            // if the node is to be placed on the left
            // (if new key is lesser than the focusNode key)

            if (focusNode.leftNode == null) {
                focusNode.leftNode = new Node(key);
                focusNode.leftNode.parentNode = focusNode;
                return focusNode.leftNode;
            } else {
                // if the left child does exist
                return insertRec(key, focusNode.leftNode);
            }
        }

        return null;
    }

    public void delete(String key) {
        Node focusNode = search(key);
        if (focusNode == null) {
            return;
        }

        Node focusNodeParent = focusNode.parentNode;
        boolean isLeftChild = false;
        if (nodeExists(focusNodeParent, "left")) {
            isLeftChild = key.equals(focusNodeParent.leftNode.key);
        }

        if (countChildren(focusNode) == 2) {
            Node focusNodeSuccessor = getSuccessor(focusNode);
            focusNodeSuccessor.leftNode = focusNode.leftNode;
            if (isLeftChild) {
                focusNodeParent.leftNode = focusNodeSuccessor;
            } else {
                focusNodeParent.rightNode = focusNodeSuccessor;
            }

            focusNode.rightNode.parentNode = null;
        }

        else if (countChildren(focusNode) == 1) {
            if (nodeExists(focusNode, "left")) {
                // if the node only has left child
                Node newChild = focusNode.leftNode; // copy new child
                focusNode.leftNode.parentNode = null; // delete focusNode from memory
                if (isLeftChild) {
                    focusNodeParent.leftNode = newChild; // link parent to child
                } else {
                    focusNodeParent.rightNode = newChild;
                }
                newChild.parentNode = focusNodeParent; // link child to parent

            } else {
                // if the node only has right child
                Node newChild = focusNode.rightNode;
                focusNode.rightNode.parentNode = null;
                if (isLeftChild) {
                    focusNodeParent.leftNode = newChild;
                } else {
                    focusNodeParent.rightNode = newChild;
                }
                newChild.parentNode = focusNodeParent;
            }
        }

        else if (countChildren(focusNode) == 0) {
            if (isLeftChild) {
                focusNodeParent.leftNode = null;
            } else {
                focusNodeParent.rightNode = null;
            }
        }
    }

    public Node rotateRight(Node focusNode) {
        Node parentNode = focusNode.parentNode;
        Node leftChild = focusNode.leftNode;
        focusNode.leftNode = leftChild.rightNode;
        if (leftChild.rightNode != null) {
            leftChild.rightNode.parentNode = leftChild;
        }

        leftChild.rightNode = focusNode;
        focusNode.parentNode = leftChild;
        leftChild.parentNode = parentNode;

        if (parentNode != null) {
            if (parentNode.leftNode == focusNode) {
                parentNode.leftNode = leftChild;
            } else {
                parentNode.rightNode = leftChild;
            }
        }

        root = getHighest();
        return leftChild;
    }

    public Node rotateLeft(Node focusNode) {
        Node parentNode = focusNode.parentNode;
        Node rightChild = focusNode.rightNode;
        focusNode.rightNode = rightChild.leftNode;

        if (rightChild.rightNode != null) {
            rightChild.rightNode.parentNode = rightChild;
        }

        rightChild.leftNode = focusNode;
        focusNode.parentNode = rightChild;
        rightChild.parentNode = parentNode;

        if (parentNode != null) {
            if (parentNode.leftNode == focusNode) {
                parentNode.leftNode = rightChild;
            } else {
                parentNode.rightNode = rightChild;
            }
        }

        root = getHighest();
        return rightChild;
    }

    public void rotateLeftRight(Node focusNode) {
        focusNode.leftNode = rotateLeft(focusNode.leftNode);
        focusNode = rotateRight(focusNode);
    }

    public void rotateRightLeft(Node focusNode) {
        focusNode.rightNode = rotateRight(focusNode.rightNode);
        focusNode = rotateLeft(focusNode);
    }

    public void balance(Node focusNode) {
        while (focusNode != null) {

            if (focusNode.getBalance() > 1) {
                // if left-heavy

                if (focusNode.leftNode.getBalance() > 0) {
                    // left-left case

                    focusNode = rotateRight(focusNode);
                } else {
                    // left-right case

                    rotateLeftRight(focusNode);
                }
            }

            else if (focusNode.getBalance() < -1) {
                // if right-heavy

                if (focusNode.rightNode.getBalance() < 0) {
                    // right-right case

                    focusNode = rotateRight(focusNode);
                } else {
                    // right-left case

                    rotateRightLeft(focusNode);
                }
            }

            focusNode = focusNode.parentNode;
        }
    }

    public Node search(String key) {
        return searchRec(key, root);
    }

    private static Node searchRec(String key, Node focusNode) {
        if (focusNode == null) {
            // if last node and not found
            return null;
        }

        if (key.equals(focusNode.key)) {
            // if node is found
            return focusNode;
        }

        // if node is not found

        if (key.compareTo(focusNode.key) > 0) {
            return searchRec(key, focusNode.rightNode);
        }

        else if (key.compareTo(focusNode.key) < 0) {
            return searchRec(key, focusNode.leftNode);
        }
        return null;
    }

    public Node getMin() {
        Node focusNode = root;
        while (nodeExists(focusNode, "left")) {
            focusNode = focusNode.leftNode;
        }

        return focusNode;
    }

    public Node getMax() {
        Node focusNode = root;
        while (nodeExists(focusNode, "right")) {
            focusNode = focusNode.rightNode;
        }

        return focusNode;
    }

    public Node getSuccessor(Node focusNode) {
        return getSuccessorRec(focusNode);
    }

    private static Node getSuccessorRec(Node focusNode) {
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

    public Node getPredecessor(Node focusNode) {
        return getPredecessorRec(focusNode);
    }

    private static Node getPredecessorRec(Node focusNode) {
        if (nodeExists(focusNode, "left")) {
            focusNode = focusNode.leftNode;
            while (nodeExists(focusNode, "right")) {
                focusNode = focusNode.rightNode;
            }
            return focusNode;
        } else {
            // if left node doesn't exist

            while (nodeExists(focusNode, "parent")) {
                Node focusNodeParent = focusNode.parentNode;
                if (focusNodeParent.rightNode == focusNode) {
                    // if parent element has a right child
                    // and this left child is the focus node

                    return focusNodeParent;
                } else {
                    // if right node isn't the focus node
                    focusNode = focusNodeParent;
                }
            }
            return null;
        }
    }

    private static boolean nodeExists(Node focusNode, String whatNode) {
        boolean doesExist;

        switch (whatNode) {
            case "right" -> {
                try {
                    // if rightNode exists, returns true
                    doesExist = focusNode.rightNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }

            case "left" -> {
                try {
                    // if leftNode exists, returns true
                    doesExist = focusNode.leftNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }

            case "parent" -> {
                try {
                    // if parentNode exists, returns true
                    doesExist = focusNode.parentNode != null;
                } catch (Exception NullPointerException) {
                    doesExist = false;
                }
                return doesExist;
            }
            default -> throw new RuntimeException("wrong node name");
        }
    }

    private static int countChildren(Node focusNode) {
        int count = 0;
        if (nodeExists(focusNode, "left")) {
            count++;
        }

        if (nodeExists(focusNode, "right")) {
            count++;
        }
        return count;
    }

    private Node getHighest() {
        Node firstNode = getMin();
        while (firstNode.parentNode != null) {
            firstNode = firstNode.parentNode;
        }

        return firstNode;
    }

    public void printAll(boolean reversed) {
        // reversed - from min to max
        // normal - max to min

        reversed = !reversed;

        if (reversed) {
            printAllRec(getMax(), reversed);
        } else {
            printAllRec(getMin(), reversed);
        }
    }

    private static void printAllRec(Node focusNode, boolean reversed){
        if (focusNode == null) {
            return;
        }

        System.out.println(focusNode.key);

        Node nextNode;
        if (reversed) {
            nextNode = getPredecessorRec(focusNode);
        } else {
            nextNode = getSuccessorRec(focusNode);
        }
        printAllRec(nextNode, reversed);
    }
}