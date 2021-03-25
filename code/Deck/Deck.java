package Deck;

import DoublyLinkedLists.DoubleLinkedList;
import DynamicArrays.DynamicArray;

public class Deck<T> {
    DoubleLinkedList<T> list = new DoubleLinkedList<T>();
    int size = 0;

    public static String emptyDeckError = "The deck is empty";

    public void pushFront(T value) {
        list.insert(value);
        size++;
    }

    public void popFront() {
        if (size-1 < 0) {
            return;
        }

        list.removeElement(0);
        size--;
    }

    public T peekFront() {

        if (list.head != null) {
            return list.head.getData();
        }

        throw new RuntimeException(emptyDeckError);
    }


    public void pushBack(T value) {
        list.append(value);
        size++;
    }

    public void popBack() {
        if (size-1 < 0) {
            return;
        }

        list.removeElement(size-1);
        size--;
    }

    public T peekBack() {

        if (list.tail != null) {
            return list.tail.getData();
        }

        throw new RuntimeException(emptyDeckError);
    }

    public void printAll() {
        list.printAll();
    }

    public int getSize() {
        return size;
    }
}