package DoublyLinkedLists;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DoubleLinkedListTests<T> extends Assert {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void list_init_listSize() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 0;

        int actual = linky.size;
        assertEquals(expected, actual);
    }

    @Test
    public void insert_listSize_increase() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 1;

        linky.insert(1);

        int actual = linky.size;
        assertEquals(expected, actual);
    }

//    @Test
//    public void insert_addsToBeginning() {
//        DoubleLinkedList linky = new DoubleLinkedList();
//        int[] expected = {3, 2, 1};
//
//        linky.insert(1);
//        linky.insert(2);
//        linky.insert(3);
//
//        int[] actual = new int[3];
//
//        assertEquals(expected, actual);
//    }

    @Test
    public void append_listSize_increase() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 1;

        linky.append(1);

        int actual = linky.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void append_valueValidation() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 2;

        linky.append(1);
        linky.append(2);

        int actual = linky.getValueByIndex(1);
        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_notEmptyList() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        boolean expected = true;

        boolean actual = linky.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty_emptyList() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        boolean expected = false;

        linky.append(1);

        boolean actual = linky.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void contains_existingValue() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        boolean expected = true;

        linky.append(1);

        boolean actual = linky.contains(1);
        assertEquals(expected, actual);
    }

    @Test
    public void contains_notExistingValue() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        boolean expected = false;

        boolean actual = linky.contains(1);
        assertEquals(expected, actual);
    }

    @Test
    public void getIndexFirst_LastElement() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 3;

        linky.append(2);
        linky.append(2);
        linky.append(2);
        linky.append(1);

        int actual = linky.findFirstOccurance(1);
        assertEquals(expected, actual);
    }

    @Test
    public void findFirstOccurance_FirstElement() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 0;

        linky.append(1);
        linky.append(2);
        linky.append(2);
        linky.append(2);

        int actual = linky.findFirstOccurance(1);
        assertEquals(expected, actual);
    }

    @Test
    public void findFirstOccurance_MultipleElements() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 2;

        linky.append(2);
        linky.append(2);
        linky.append(1);
        linky.append(2);
        linky.append(1);

        int actual = linky.findFirstOccurance(1);
        assertEquals(expected, actual);
    }

    @Test
    public void findFirstOccurance_NotExistingElement_ThrowsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.elementNotFoundError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        linky.insert(1);

        linky.findFirstOccurance(2);
    }

    @Test
    public void findFirstOccurance_EmptyArray_ThrowsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.listIsEmptyError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();

        linky.findFirstOccurance(2);
    }

    @Test
    public void getSize_EmptyList() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 0;

        int actual = linky.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void getSize_NotEmptyList() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 4;

        linky.append(3);
        linky.append(3);
        linky.append(3);
        linky.append(3);

        int actual = linky.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void getValueByIndex_FirstIndex() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 0;

        linky.append(0);
        linky.append(1);
        linky.append(2);
        linky.append(3);

        int actual = linky.getValueByIndex(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getValueByIndex_LastIndex() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 4;

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        int actual = linky.getValueByIndex(3);
        assertEquals(expected, actual);
    }

    @Test
    public void getValueByIndex_NegativeIndex_ThrowsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.outOfRangeError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.getValueByIndex(-1);
    }

    @Test
    public void getValueByIndex_IndexGreaterSize_ThrowsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.outOfRangeError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.getValueByIndex(100);
    }

    @Test
    public void setValueByIndex_FirstIndex() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 100;

        linky.append(0);
        linky.append(1);
        linky.append(2);
        linky.append(3);

        linky.setValueByIndex(0, 100);

        int actual = linky.getValueByIndex(0);
        assertEquals(expected, actual);
    }

    @Test
    public void setValueByIndex_LastIndex() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 100;

        linky.append(0);
        linky.append(1);
        linky.append(2);
        linky.append(3);

        linky.setValueByIndex(3, 100);

        int actual = linky.getValueByIndex(3);
        assertEquals(expected, actual);
    }

    @Test
    public void setValueByIndex_NegativeIndex_ThrowsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.outOfRangeError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.setValueByIndex(-1, 1000);
    }

    @Test
    public void setValueByIndex_IndexGreaterSize_ThrowsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.outOfRangeError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.setValueByIndex(1000, 1000);
    }

    @Test
    public void removeElementByValue_firstElement() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 2;

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.removeElementByValue(1);

        int actual = linky.getValueByIndex(0);
        assertEquals(expected, actual);
    }

    @Test
    public void removeElementByValue_LastElement() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 3;

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.removeElementByValue(4);

        int actual = linky.getValueByIndex(2);
        assertEquals(expected, actual);
    }

    @Test
    public void removeElementByValue_MiddleElement() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 4;

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.removeElementByValue(2);

        int actual = linky.getValueByIndex(2);
        assertEquals(expected, actual);
    }

    @Test
    public void removeElementByValue_ListSize() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 3;

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.removeElementByValue(2);

        int actual = linky.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void removeElementByValue_NotExistingValue() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.elementNotFoundError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.removeElementByValue(1000);
    }

    @Test
    public void insertAfter_listSize_increase() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 4;

        linky.append(1);
        linky.append(2);
        linky.append(3);

        linky.insertAfter(linky.findFirstNodeByValue(2), 33);

        int actual = linky.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void insertAfter_valueValidation() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 22;

        linky.append(1);
        linky.append(2);

        linky.insertAfter(linky.findFirstNodeByValue(2), 22);

        int actual = linky.getValueByIndex(2);
        assertEquals(expected, actual);
    }

    @Test
    public void insertAfter_NotExistingNode_ThrowsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.elementNotFoundError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        DoubleLinkedListElement<Integer> check = new DoubleLinkedListElement<Integer>(33);
        linky.insertAfter(check, 10);
    }

    @Test
    public void insertBefore_listSize_increase() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 4;

        linky.append(1);
        linky.append(2);
        linky.append(3);

        linky.insertBefore(linky.findFirstNodeByValue(2), 33);

        int actual = linky.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void insertBefore_valueValidation() {
        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();
        int expected = 22;

        linky.append(1);
        linky.append(2);

        linky.insertBefore(linky.findFirstNodeByValue(2), 22);

        int actual = linky.getValueByIndex(1);
        assertEquals(expected, actual);
    }

    @Test
    public void insertBefore_NotExistingNode_ThrowsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(DoubleLinkedList.elementNotFoundError);

        DoubleLinkedList<Integer> linky = new DoubleLinkedList<Integer>();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        DoubleLinkedListElement<Integer> check = new DoubleLinkedListElement<Integer>(33);
        linky.insertBefore(check, 10);
    }
}