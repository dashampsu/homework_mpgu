package com.company;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class DynamicArray_tests extends Assert {

    @Test
    public void init_sizeDefault() {
        DynamicArray array = new DynamicArray();
        int expected = array.defaultSize;

        int actual = array.getsize();
        assertEquals(expected, actual);
    }

    @Test
    public void init_SizeCustom() {
        DynamicArray array = new DynamicArray(10);
        int expected = 10;

        int actual = array.getsize();
        assertEquals(expected, actual);
    }

    @Test
    public void getSize() {
        DynamicArray array = new DynamicArray();
        int expected = 2;

        int actual = array.list.length;
        assertEquals(expected, actual);
    }

    @Test
    public void reSize() {
        DynamicArray array = new DynamicArray(10);
        int expected = 5;

        array.resize(5);

        int actual = array.getsize();
        assertEquals(expected, actual);
    }
}
