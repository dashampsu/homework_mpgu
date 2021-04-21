import BinarySearchTree.*;
import BinarySearchTree.Utils.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree("");
//        tree.insert("abc");
//        tree.insert("abcd");
//        tree.insert("abcdefghijk");
//        tree.insert("abcdefghi");
//        tree.insert("ab");
//        tree.insert("abcdefghijklmnopqrst");
//        tree.insert("abcdefghijklmnopq");
//        tree.insert("abcde");
//        tree.insert("a");
//        tree.insert("abcdefghijklmno");
//        tree.insert("abcdefghijklmnopqr");

//        tree.insert("ab");
//        tree.insert("a");
//        tree.insert("abcd");
//        tree.insert("abc");
//        tree.insert("abcdef");
//        tree.insert("abcde");
//        tree.insert("abcdefg");

        tree.insert("abcde");
        tree.insert("abcdef");
        tree.insert("abc");
        tree.insert("abcd");
        tree.insert("ab");

        System.out.println(TreePrinter.getTreeDisplay(tree.getRoot()));

        tree.rightRotate(tree.search("abcde"));

        System.out.println(TreePrinter.getTreeDisplay(tree.getRoot()));
    }
}
