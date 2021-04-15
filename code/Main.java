import BinarySearchTree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abc");
        tree.insert("abcd");
        tree.insert("abcdefg");

        tree.printAll();
    }
}
