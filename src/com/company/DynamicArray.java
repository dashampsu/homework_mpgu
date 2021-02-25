package com.company;

public class DynamicArray<T> {

    // .......... переменные ..........
    public T[] list;
    public int defaultSize = 2;

    // .......... ошибки ..........
    public static String outOfBorderError = "Выход за границы массива";
    public static String wrongArraySizeError = "Массив должен быть больше 1";
    public static String elementNotFoundError = "Такого элемента не существует";

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

        System.arraycopy(list, 0, newList, 0, newSize);

        list = newList;
    }

    public void set(int index, T value) {
        if (index < 0 || index > list.length) {
            throw new RuntimeException(outOfBorderError);
        }

        list[index] = value;
    }

    public int findFirst(T value) {

        for (int i=0; i < list.length; i++) {
            if (list[i] == value) { return i; }
        }

        throw new RuntimeException(elementNotFoundError);
    }

    public int findLast(T value) {

        int last_index = -1;
        for (int i=0; i < list.length; i++) {
            if (list[i] == value) {
                last_index = i;
            }
        }

        if (last_index >= 0) {
            return last_index;
        }

        throw new RuntimeException(elementNotFoundError);
    }
}
