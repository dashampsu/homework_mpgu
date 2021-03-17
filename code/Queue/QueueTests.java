package Queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTests {

    @Test
    public void enqueue_check_data() {
        Queue queue = new Queue();
        int expected = 10;

        queue.enqueue(10);

        Object actual = queue.peek();
        assertEquals(expected, actual);

        expected = 10;
        queue.enqueue(20);
        actual = queue.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void enqueue_check_size() {
        Queue queue = new Queue();
        int expected = 1;

        queue.enqueue(10);

        Object actual = queue.size();
        assertEquals(expected, actual);

        expected = 2;
        queue.enqueue(20);
        actual = queue.size();
        assertEquals(expected, actual);
    }

    @Test
    public void dequeue_check_data() {
        Queue queue = new Queue();
        int expected = 20;

        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();

        Object actual = queue.peek();
        assertEquals(expected, actual);

        expected = 20;
        actual = queue.peek();
        assertEquals(expected, actual);
    }

    @Test
    public void dequeue_check_size() {
        Queue queue = new Queue();
        int expected = 1;

        queue.enqueue(3);
        queue.enqueue(3);

        queue.dequeue();

        Object actual = queue.size();
        assertEquals(expected, actual);

        expected = 0;
        queue.dequeue();
        actual = queue.size();
        assertEquals(expected, actual);
    }

    @Test
    public void size_check_size() {
        Queue queue = new Queue();
        int expected = 1;

        queue.enqueue(3);
        queue.enqueue(3);

        queue.dequeue();

        Object actual = queue.size();
        assertEquals(expected, actual);

        expected = 0;
        queue.dequeue();
        actual = queue.size();
        assertEquals(expected, actual);
    }
}
