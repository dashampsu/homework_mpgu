package com.company;

public class DynamicArray<T> {

    // .......... переменные ..........
    public T[] list;
    public int defaultSize = 2;

    // .......... ошибки ..........
    public static String wrongArraySizeError = "Размер массива должен быть не меньше 1";

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
        if (newSize < 1) {
            throw new RuntimeException(wrongArraySizeError);
        }

        T[] newList = (T[]) new Object[newSize];

        int counter = 0;
        for (T item : newList) {
            item = list[counter];
            counter++;
        }

        list = newList;
    }


}
