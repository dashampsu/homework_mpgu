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

    public int getsize() {
        return list.length;
    }

    public void resize(int newSize) {
        T[] newList = (T[]) new Object[newSize];

        int counter = 0;
        for (T item : newList) {
            item = list[counter];
            counter++;
        }

        list = newList;
    }


}
