import BinarySearchTree.*;
import BinarySearchTree.Utils.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree("abcdefgh");
        tree.insert("abc");
        tree.insert("abcd");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghi");
        tree.insert("ab");
        tree.insert("abcdefghijklmnopqrst");
        tree.insert("abcdefghijklmnopq");
        tree.insert("abcde");
        tree.insert("a");
        tree.insert("abcdefghijklmno");
        tree.insert("abcdefghijklmnopqr");

        tree.printAll(false);

        System.out.println(TreePrinter.getTreeDisplay(tree.search("abcdefgh")));

        tree.delete("abc");

        System.out.println(TreePrinter.getTreeDisplay(tree.search("abcdefgh")));

        // task 9 complete
    }
}
