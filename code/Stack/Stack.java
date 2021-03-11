package Stack;
import DoublyLinkedLists.DoubleLinkedList;
import DoublyLinkedLists.DoubleLinkedListElement;

public class Stack {
    DoubleLinkedList linky = new DoubleLinkedList();
    int counter = 0;

    public void append(int data) {
        linky.append(data);
    }

    public void pop() {
        linky.pop();
    }

    public int get() {
        return linky.getTail();
    }

    public void printAll() {
        linky.printAll();
    }
}
