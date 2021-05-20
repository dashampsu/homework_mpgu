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
        int actual = table.get(0).get(0).data;
        assertEquals(expected, actual);
    }

    @Test
    public void insert_collision_positive() {
        ListHashArray table = new ListHashArray(9);
        table.insert(9);
        table.insert(18);

        int expected = 18;
        int actual = table.get(0).get(1).data;
        assertEquals(expected, actual);
    }

    @Test
    public void get_positive() {
        ListHashArray table = new ListHashArray(9);
        table.insert(9);

        int expected = 9;
        int actual = table.get(0).get(0).data;
        assertEquals(expected, actual);
    }

    @Test
    public void getElement_wrongIndex_ThrowsException() {
        ListHashArray table = new ListHashArray(9);
        String error_message = table.outOfBoundsException;

        assertThrows(RuntimeException.class, () -> table.get(20), error_message);
        assertThrows(RuntimeException.class, () -> table.get(-2), error_message);
    }

    @Test
    public void remove_positive() {
        ListHashArray table = new ListHashArray(9);
        table.insert(9);
        table.insert(18);

        table.remove(0);

        int expected = 0;
        int actual = table.get(0).getsize();
        assertEquals(expected, actual);
    }

    @Test
    public void remove_outofBoundsException() {
        ListHashArray table = new ListHashArray(9);
        String error_message = table.outOfBoundsException;

        assertThrows(RuntimeException.class, () -> table.remove(20), error_message);
        assertThrows(RuntimeException.class, () -> table.remove(-2), error_message);
    }
}

