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

    public void delete(String key) {
        Node focusNode = getMax();

        while (focusNode != null) {
            if (key.equals(focusNode.key)) {
                Node focusNodeParent = focusNode.parentNode;

                if (nodeExists(focusNodeParent, "left")) {
                    if (key.equals(focusNodeParent.leftNode.key)) {
                        // if parent node has left child
                        // and that child has the key value

                        if (countChildren(focusNode) == 1) {
                            if (nodeExists(focusNode, "left")) {
                                focusNodeParent.leftNode = null;
                                focusNodeParent.leftNode = focusNode.leftNode;
                                focusNode.leftNode.parentNode = focusNodeParent;
                                return;
                            } else {
                                focusNodeParent.leftNode = null;
                                focusNodeParent.leftNode = focusNode.rightNode;
                                focusNode.rightNode.parentNode = focusNodeParent;
                                return;
                            }
                        }

                        else if (countChildren(focusNode) == 0) {
                            focusNodeParent.leftNode = null;
                        }
                    }
                }

                if (nodeExists(focusNodeParent, "right")) {
                    if (key.equals(focusNodeParent.rightNode.key)) {
                        // if the parent node has right child
                        // and that child has the key value

                        if (countChildren(focusNode) == 1) {
                            if (nodeExists(focusNode, "left")) {
                                focusNodeParent.rightNode = null;
                                focusNodeParent.rightNode = focusNode.leftNode;
                                focusNode.leftNode.parentNode = focusNodeParent;
                                return;
                            } else {
                                focusNodeParent.rightNode = null;
                                focusNodeParent.rightNode = focusNode.rightNode;
                                focusNode.rightNode.parentNode = focusNodeParent;
                                return;
                            }
                        }

                        else if (countChildren(focusNode) == 0) {
                            focusNodeParent.rightNode = null;
                        }
                    }
                }
            }

            focusNode = getPredecessor(focusNode);
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
}
