import DoublyLinkedLists.*;
import Stack.*;
import Queue.*;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();

        queue.printAll();
    }
}
