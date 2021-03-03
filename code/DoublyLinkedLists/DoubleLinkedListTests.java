package DoublyLinkedLists;

import org.junit.Assert;
import org.junit.Test;

public class DoubleLinkedListTests extends Assert {

    @Test
    public void list_init_listSize() {
        DoubleLinkedList listy = new DoubleLinkedList();
        int expected = 0;

        int actual = listy.size;
        assertEquals(expected, actual);
    }

    @Test
    public void list_insert_listSize() {
        DoubleLinkedList listy = new DoubleLinkedList();
        boolean expected = true;

        listy.insert(1);

        boolean actual = listy.contains(1);
        assertEquals(expected, actual);
    }
}
