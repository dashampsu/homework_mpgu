import BinarySearchTree.*;
import BinarySearchTree.Utils.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree("abcde");
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

        tree.insert("abcd");
        tree.insert("ab");
        tree.insert("abc");
        tree.insert("a");


        System.out.println(TreePrinter.getTreeDisplay(tree.search("abcde")));

        System.out.println(tree.search("abcde").getBalance());
    }
}
