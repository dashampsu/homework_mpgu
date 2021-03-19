package Queue;
import DynamicArrays.*;

public class Queue<T> {
    DynamicArray<T> queue = new DynamicArray<T>();
    int size = 0;

    public void enqueue(T value) {
        queue.add(value);
        size++;
    }

    public void dequeue() {
        queue.remove(0);
        size--;
    }


//
//    public void dequeue() {
//        DoubleLinkedListElement<T> nodeToSet = queue.getNodeByIndex(1);
//        queue.setNodeByIndex(0, nodeToSet);
//        size--;
//    }
//
//    public T peek() {
//        return queue.head.getData();
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public void printAll() {
//        queue.printAll();
//    }
}
