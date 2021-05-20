package HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HashTableTests {

    @Test
    public void creation_positive() {
        ListHashTable table = new ListHashTable(9);
    }

    @Test
    public void insert_positive() {
        ListHashTable table = new ListHashTable(9);
        table.insert(9);

        int expected = 9;
        int actual = table.getByKey(0).getValueByIndex(0).data;
        assertEquals(expected, actual);
    }

    @Test
    public void get_positive() {
        ListHashTable table = new ListHashTable(9);
        table.insert(9);

        int expected = 9;
        int actual = table.getByKey(0).getValueByIndex(0).data;
        assertEquals(expected, actual);
    }

    @Test
    public void get_outOfBoundException() {
        ListHashTable table = new ListHashTable(9);
        table.insert(9);

        int expected = 9;
        int actual = table.getByKey(0).getValueByIndex(0).data;
        assertEquals(expected, actual);
    }
}
