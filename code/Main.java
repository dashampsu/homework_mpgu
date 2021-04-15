import BinarySearchTree.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree("abcdefgh");
        tree.insert("abc");
        tree.insert("abcd");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghi");
        tree.insert("a");
        tree.insert("abcdefghijklmnopq");
        tree.insert("abcdefghijklmn");

        tree.printAll(false);
        System.out.println();

        tree.delete("abcdefghijklmnopq");
        tree.printAll(false);
    }
}
