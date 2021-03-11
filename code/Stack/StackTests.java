package Stack;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StackTests {

    @Test
    public void init_size() {
        Stack stack = new Stack();
        int expected = 0;

        int actual = stack.getSize();
        assertEquals(expected, actual);
    }


    @Test
    public void push_size_Validation() {
        Stack stack = new Stack();
        int expected = 2;

        stack.push(1);
        stack.push(1);

        int actual = stack.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void push_data_Validation() {
        Stack stack = new Stack();
        int expected = 123;

        stack.push(12);
        stack.push(123);

        int actual = stack.peek();
        assertEquals(expected, actual);

        expected = 12;
        stack.pop();
        actual = stack.peek();
        assertEquals(expected, actual);
    }


}
