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

    @Test
    public void pop_size_Validation() {
        Stack stack = new Stack();
        int expected = 2;

        stack.push(1);
        stack.push(1);
        stack.push(1);

        stack.pop();

        int actual = stack.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void pop_data_Validation() {
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

    @Test
    public void pop_EmptyStack() {
        Stack stack = new Stack();

        stack.pop();
    }

    @Test
    public void getSize_validation() {
        Stack stack = new Stack();
        int expected = 1;

        stack.push(1);

        int actual = stack.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void getSize_EmptyStack() {
        Stack stack = new Stack();
        int expected = 0;

        int actual = stack.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_emptyStack() {
        Stack stack = new Stack();
        boolean expected = true;

        boolean actual = stack.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_NotEmptyStack() {
        Stack stack = new Stack();
        boolean expected = false;

        stack.push(1);

        boolean actual = stack.isEmpty();
        assertEquals(expected, actual);
    }

}
