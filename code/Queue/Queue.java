package Queue;

import DoublyLinkedLists.DoubleLinkedList;

public class Queue {
    DoubleLinkedList queue = new DoubleLinkedList();
    int size = 0;

    public void enqueue(int value) {
        queue.append(value);
    }
}
