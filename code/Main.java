import BinarySearchTree.*;
import BinarySearchTree.Utils.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcdef");
        tree.insert("abcdefg");
        tree.insert("abcd");
        tree.insert("abcde");
        tree.insert("abc");
        tree.insert("ab");
        tree.insert("a");


        System.out.println(TreePrinter.getTreeDisplay(tree.root));
    }
}
