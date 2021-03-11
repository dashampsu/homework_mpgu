package Stack;
import DoublyLinkedLists.DoubleLinkedList;
import DoublyLinkedLists.DoubleLinkedListElement;

public class Stack {
    DoubleLinkedList linky = new DoubleLinkedList();
    int counter = 0;

    public void append(int data) {
        linky.append(data);
        counter++;
    }

    public void pop() {
        linky.pop();
        counter--;
    }

    public int get() {
        return linky.getTail();
    }

    public int getSize() {
        return counter;
    }

    public boolean isEmpty() {
        if (counter == 0) {
            return false;
        }

        return true;
    }

    public void printAll() {
        linky.printAll();
    }
}
