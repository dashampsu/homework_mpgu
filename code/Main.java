import BinarySearchTree.*;
import BinarySearchTree.Utils.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
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

        tree.insert("abcd");
        tree.insert("abcde");
        tree.insert("ab");
        tree.insert("abc");
        tree.insert("a");


        System.out.println(TreePrinter.getTreeDisplay(tree.root));
        tree.rotateLeftRight(tree.root);
        System.out.println(TreePrinter.getTreeDisplay(tree.root));

        System.out.println(tree.root.getBalance());

    }
}
