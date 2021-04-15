import BinarySearchTree.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree("abcdefghijklmn");
        tree.insert("abc");
        tree.insert("abcd");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghi");
        tree.insert("a");
        tree.insert("abcdefghijklmnopq");

//        System.out.println(tree.getMax().getKey());

        tree.printAll(false);
        System.out.println();
        tree.printAll(true);

//        Node node = tree.search("abcdefghi");
//        System.out.println(node.getKey());
    }
}
