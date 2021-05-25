package HashTableArrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListHashArrayTests {

    @Test
    public void creation_positive() {
        ListHashArray table = new ListHashArray(9);
    }

    @Test
    public void insert_positive() {
        ListHashArray table = new ListHashArray(9);
        table.insert(9);

        int expected = 9;
        int actual = table.get(9).data;
        assertEquals(expected, actual);
    }

    @Test
    public void insert_collision_positive() {
        ListHashArray table = new ListHashArray(9);
        table.insert(9);
        table.insert(18);

        int expected = 18;
        int actual = table.get(0).data;
        assertEquals(expected, actual);
    }

    @Test
    public void get_positive() {
        ListHashArray table = new ListHashArray(9);
        table.insert(9);

        int expected = 9;
        int actual = table.get(9).data;
        assertEquals(expected, actual);
    }

    @Test
    public void remove_positive() {
        ListHashArray table = new ListHashArray(9);
        table.insert(9);
        table.insert(18);

        table.remove(18);

        Object expected = null;
        Object actual = table.get(18);
        assertEquals(expected, actual);
    }
}

