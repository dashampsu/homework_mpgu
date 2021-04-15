import BinarySearchTree.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abc");
        tree.insert("abcd");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghi");

        tree.printAll();

        Node node = tree.search("abcdefghi");
        System.out.println(node.getKey());
    }
}
