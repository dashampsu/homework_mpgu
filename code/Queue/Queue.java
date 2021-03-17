package Queue;

import DoublyLinkedLists.DoubleLinkedList;
import DoublyLinkedLists.DoubleLinkedListElement;

public class Queue {
    DoubleLinkedList queue = new DoubleLinkedList();
    int size = 0;

    public void enqueue(int value) {
        queue.append(value);
        size++;
    }

    public void dequeue() {
        DoubleLinkedListElement nodeToSet = queue.getNodeByIndex(1);
        queue.setNodeByIndex(0, nodeToSet);
        size--;
    }

    public Object peek() {
        return queue.head.getData();
    }

    public int size() {
        return size;
    }

    public void printAll() {
        queue.printAll();
    }
}
