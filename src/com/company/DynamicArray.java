package com.company;

public class DynamicArray<T> {
    public T[] list;
    public int defaultSize = 2;

    public DynamicArray() {
        list = (T[]) new Object[defaultSize];
    }

    public DynamicArray(int size) {
        list = (T[]) new Object[size];
    }

    public int size() {
        return list.length;
    }
}
