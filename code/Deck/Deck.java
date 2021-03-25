package Deck;

import DoublyLinkedLists.DoubleLinkedList;
import DynamicArrays.DynamicArray;

public class Deck<T> {
    DoubleLinkedList<T> list = new DoubleLinkedList<T>();
    int size = 0;

    public void push_front(T value) {
        list.insert(value);
        size++;
    }

    public T peek_front() {
        return list.head.getData();
    }

    public void pop_front() {
        list.removeElement(0);
        size--;
    }


    public void push_back(T value) {
        list.append(value);
        size++;
    }

    public T peek_back() {
        return list.tail.getData();
    }

    public void pop_back() {
        list.removeElement(size);
        size--;
    }

    public void printAll() {
        list.printAll();
    }
}