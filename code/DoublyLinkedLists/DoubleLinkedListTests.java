package DoublyLinkedLists;

import org.junit.Assert;
import org.junit.Test;

public class DoubleLinkedListTests extends Assert {

    @Test
    public void list_init_listSize() {
        DoubleLinkedList linky = new DoubleLinkedList();
        int expected = 0;

        int actual = linky.size;
        assertEquals(expected, actual);
    }

    @Test
    public void insert_listSize_increase() {
        DoubleLinkedList linky = new DoubleLinkedList();
        int expected = 1;

        linky.insert(1);

        int actual = linky.size;
        assertEquals(expected, actual);
    }

//    @Test
//    public void insert_addsToBeginning() {
//        DoubleLinkedList linky = new DoubleLinkedList();
//        int[] expected = {3, 2, 1};
//
//        linky.insert(1);
//        linky.insert(2);
//        linky.insert(3);
//
//        int[] actual = new int[3];
//
//        assertEquals(expected, actual);
//    }

    @Test
    public void append_listSize_increase() {
        DoubleLinkedList linky = new DoubleLinkedList();
        boolean expected = true;

        linky.append(1);

        boolean actual = linky.contains(1);
        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_notEmptyList() {
        DoubleLinkedList linky = new DoubleLinkedList();
        boolean expected = true;

        boolean actual = linky.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_emptyList() {
        DoubleLinkedList linky = new DoubleLinkedList();
        boolean expected = false;

        linky.append(1);

        boolean actual = linky.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void contains_existingValue() {
        DoubleLinkedList linky = new DoubleLinkedList();
        boolean expected = true;

        linky.append(1);

        boolean actual = linky.contains(1);
        assertEquals(expected, actual);
    }

    @Test
    public void contains_notExistingValue() {
        DoubleLinkedList linky = new DoubleLinkedList();
        boolean expected = false;

        boolean actual = linky.contains(1);
        assertEquals(expected, actual);
    }

}
