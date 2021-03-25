package Deck;

import DoublyLinkedLists.DoubleLinkedList;
import DynamicArrays.DynamicArray;

public class Deck<T> {
    DoubleLinkedList<T> list = new DoubleLinkedList<T>();
    int size = 0;

    public void push_front(T value) {
        list.insert(value);
    }
}