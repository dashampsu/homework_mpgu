package com.company;

public class DynamicArray<T> {
    private T[] list;
    private int defaultSize = 2;

    public DynamicArray() {
        list = (T[]) new Object[defaultSize];
    }

    public DynamicArray(int size) {
        list = (T[]) new Object[size];
    }
}
