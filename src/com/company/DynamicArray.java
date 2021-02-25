package com.company;

public class DynamicArray<T> {

    // .......... переменные ..........
    public T[] list;
    public int defaultSize = 2;

    // .......... ошибки ..........
    public static String outOfBorderError = "Выход за границы массива";
    public static String wrongArraySizeError = "Массив должен быть больше 1";

    public DynamicArray() {
        list = (T[]) new Object[defaultSize];
    }

    public DynamicArray(int size) {
        if (size < 1) {
            throw new RuntimeException(wrongArraySizeError);
        }

        list = (T[]) new Object[size];
    }

    public int getsize() {
        return list.length;
    }

    public T get(int index) {
        if (index < 0 || index > list.length) {
            throw new RuntimeException(outOfBorderError);
        }

        return list[index];
    }

    public void resize(int newSize) {
        if (newSize < 1) {
            throw new RuntimeException(wrongArraySizeError);
        }

        T[] newList = (T[]) new Object[newSize];

        for (int i=0; i < newSize; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }

    public void set(int index, T value) {
        if (index < 0 || index > list.length) {
            throw new RuntimeException(outOfBorderError);
        }

        list[index] = value;
    }
}
