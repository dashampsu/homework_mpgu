package com.company;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class DynamicArray_tests extends Assert {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void reSize_length() {
        DynamicArray array = new DynamicArray(10);
        int expected = 5;

        array.resize(5);

        int actual = array.getsize();
        assertEquals(expected, actual);
    }

    @Test
    public void reSize_length_negative() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongArraySizeError);

        DynamicArray array = new DynamicArray(-1);
    }

    @Test
    public void reSize_length_zero() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongArraySizeError);

        DynamicArray array = new DynamicArray(0);
    }

    @Test
    public void reSize_value() {
        DynamicArray array = new DynamicArray(10);
        String expected = "ama here";

        array.set(0, "ama here");
        array.resize(5);

        Object actual = array.get(0);
        assertEquals(expected, actual);
    }
}
