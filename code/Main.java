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
        tree.insert("abcde");

        tree.printAll(false);
        System.out.println();

        tree.delete("abcd");
        tree.printAll(false);

//        System.out.println(tree.search("abcdefghijklmn").getParentNode().getKey());
    }
}
