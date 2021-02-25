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
    public void getSize_int() {
        DynamicArray array = new DynamicArray();
        int expected = 2;

        int actual = array.list.length;
        assertEquals(expected, actual);
    }

    @Test
    public void reSize_length() {
        DynamicArray array = new DynamicArray(10);
        int expected = 5;

        array.resize(expected);

        int actual = array.getsize();
        assertEquals(expected, actual);
    }

    @Test
    public void reSize_negative() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongArraySizeError);

        DynamicArray array = new DynamicArray(-1);
    }

    @Test
    public void reSize_zero() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.wrongArraySizeError);

        DynamicArray array = new DynamicArray(0);
    }

    @Test
    public void reSize_valueValidation() {
        DynamicArray array = new DynamicArray(10);
        String expected = "ama here";

        array.set(0, expected);
        array.resize(5);

        Object actual = array.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void get() {
        DynamicArray array = new DynamicArray(10);
        String expected = "ama here";

        array.set(0, expected);

        Object actual = array.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void get_negative() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.outOfBorderError);

        DynamicArray array = new DynamicArray();
        array.get(-1);
    }

    @Test
    public void get_greaterThanLength() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.outOfBorderError);

        DynamicArray array = new DynamicArray();

        int index = array.getsize() + 1;

        array.get(index);
    }

    @Test
    public void set_int() {
        DynamicArray array = new DynamicArray(10);
        String expected = "ama here";

        array.set(0, expected);

        Object actual = array.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void set_multipleTypes() {
        DynamicArray array = new DynamicArray(10);
        String expected = "ama here";
        int expected2 = 2;

        array.set(0, expected);
        array.set(1, expected2);

        Object actual = array.get(0);
        Object actual2 = array.get(1);
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    public void set_negative() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.outOfBorderError);

        DynamicArray array = new DynamicArray();
        array.set(-1, 55);
    }

    @Test
    public void set_greaterThanLength() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.outOfBorderError);

        DynamicArray array = new DynamicArray();

        int index = array.getsize() + 1;

        array.set(index, 55);
    }

    @Test
    public void findFirst_int() {
        DynamicArray array = new DynamicArray(10);
        int expected = 5;

        for (int i=0; i < array.getsize(); i++) {
            array.set(i, "empty");
        }

        array.set(expected, 10);

        int actual = array.findFirst(10);
        assertEquals(expected, actual);
    }

    @Test
    public void findFirst_int_multiple() {
        DynamicArray array = new DynamicArray(10);
        int expected = 5;

        for (int i=0; i < array.getsize(); i++) {
            array.set(i, "empty");
        }

        array.set(expected, 10);
        array.set(expected + 1, 10);

        int actual = array.findFirst(10);
        assertEquals(expected, actual);
    }

    @Test
    public void findFirst_NotExisting() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.elementNotFoundError);

        DynamicArray array = new DynamicArray();
        array.findFirst("f");

    }

    @Test
    public void findLast_int() {
        DynamicArray array = new DynamicArray(10);
        int expected = 5;

        for (int i=0; i < array.getsize(); i++) {
            array.set(i, "empty");
        }

        array.set(expected, 10);

        int actual = array.findLast(10);
        assertEquals(expected, actual);
    }

    @Test
    public void findLast_int_multiple() {
        DynamicArray array = new DynamicArray(10);
        int expected = 5;

        for (int i=0; i < array.getsize(); i++) {
            array.set(i, "empty");
        }

        array.set(expected, 10);
        array.set(expected - 1, 10);

        int actual = array.findLast(10);
        assertEquals(expected, actual);
    }

    @Test
    public void findLast_NotExisting() throws RuntimeException {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DynamicArray.elementNotFoundError);

        DynamicArray array = new DynamicArray();
        array.findLast(1);

    }
}
