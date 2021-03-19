package Stack;
import DoublyLinkedLists.DoubleLinkedList;
import DoublyLinkedLists.DoubleLinkedListElement;

public class Stack<T> {
    DoubleLinkedList<T> linky = new DoubleLinkedList<T>();
    int counter = 0;

    public void push(T data) {
        linky.append(data);
        counter++;
    }

    public void pop() {
        linky.pop();
        counter--;
    }

    public T peek() {
        return linky.getTail();
    }

    public int getSize() {
        return counter;
    }

    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        }

        return false;
    }

    public void printAll() {
        linky.printAll();
    }
}
