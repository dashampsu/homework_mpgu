package BinarySearchTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTests {

    @Test
    public void insertion_GeneralTest_positive() {
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
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefghijklmnopqr");

        String expected = "abcdefghijklmnop";
        String actual = tree.getSuccessor(tree.search("abcdefghijk")).getKey();
        assertEquals(expected, actual);

        expected = "abcdefghi";
        actual = tree.getSuccessor(tree.search("abcdefgh")).getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void min_GeneralTest_positive() {
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
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefghijklmnopqr");

        String expected = "a";
        String actual = tree.getMin().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void max_GeneralTest_positive() {
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
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefghijklmnopqr");

        String expected = "abcdefghijklmnopqrst";
        String actual = tree.getMax().getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void getSuccessor_GeteralTest_positive() {
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
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefghijklmnopqr");

        String expected = "abcdefghijklmnop";
        String actual = tree.getSuccessor(tree.search("abcdefghijk")).getKey();
        assertEquals(expected, actual);

        expected = "abcdefghi";
        actual = tree.getSuccessor(tree.search("abcdefgh")).getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void getPredecessor_GeneralTest_positive() {
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
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefghijklmnopqr");

        String expected = "abcde";
        String actual = tree.getPredecessor(tree.search("abcdefgh")).getKey();
        assertEquals(expected, actual);

        expected = "abcdefghi";
        actual = tree.getPredecessor(tree.search("abcdefghijk")).getKey();
        assertEquals(expected, actual);
    }

    @Test
    public void insertionTest_positive() {
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
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefghijklmnopqr");

        tree.delete("abcdefghijklmnopqrst");

        String expected = null;
        Object actual = tree.getSuccessor(tree.search("abcdefghijklmnopqr"));
        assertEquals(expected, actual);
    }
}
