package Deck;

import DoublyLinkedLists.DoubleLinkedList;
import DynamicArrays.DynamicArray;

public class Deck<T> {
    DoubleLinkedList<T> list = new DoubleLinkedList<T>();
    int size = 0;

    public void pushFront(T value) {
        list.insert(value);
        size++;
    }

    public T peekFront() {
        return list.head.getData();
    }

    public void popFront() {
        if (size-1 < 0) {
            return;
        }

        list.removeElement(0);
        size--;
    }


    public void pushBack(T value) {
        list.append(value);
        size++;
    }

    public T peekBack() {
        return list.tail.getData();
    }

    public void popBack() {
        if (size-1 < 0) {
            return;
        }

        list.removeElement(size-1);
        size--;
    }

    public void printAll() {
        list.printAll();
    }

    public int getSize() {
        return size;
    }
}