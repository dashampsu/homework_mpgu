package Deck;

import DoublyLinkedLists.DoubleLinkedList;
import DynamicArrays.DynamicArray;

public class Deck<T> {
    DoubleLinkedList<T> list = new DoubleLinkedList<T>();
    int size = 0;

    public void push_front(T value) {
        list.insert(value);
    }

    public T peek_front() {
        return list.head.getData();
    }




    public void push_back(T value) {
        list.append(value);
    }



    public void printAll() {
        list.printAll();
    }
}