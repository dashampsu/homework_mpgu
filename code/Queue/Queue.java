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

    public T peek() {
        return queue.get(0);
    }

    public int size() {
        return size;
    }



    public void printAll() {
        queue.printAll();
    }

}
