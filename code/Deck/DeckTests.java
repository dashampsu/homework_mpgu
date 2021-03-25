package Deck;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class DeckTests {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void deck_init_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        int expected = 0;
        int actual = deck.getSize();
        assertEquals(expected, actual);
    }

    /* pushFront tests */

    @Test
    public void pushFront_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushFront(1);
        deck.pushFront(1);
        deck.pushFront(1);
        deck.pushFront(1);
        deck.pushFront(1);

        int expected = 5;
        int actual = deck.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void pushFront_dataTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushFront(1);
        deck.pushFront(2);
        deck.pushFront(3);
        deck.pushFront(4);
        deck.pushFront(5);

        int expected = 5;
        int actual = deck.peekFront();
        assertEquals(expected, actual);
    }

    /* popFront tests */

    @Test
    public void popFront_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(2);
        deck.pushBack(3);

        deck.popFront();

        int expected = 2;
        int actual = deck.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void popFront_sizeTest_negativeSize() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(2);
        deck.pushBack(3);

        deck.popFront();
        deck.popFront();
        deck.popFront();
        deck.popFront();

        int expected = 0;
        int actual = deck.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void popFront_dataTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(2);
        deck.pushBack(3);

        int expected = 1;
        int actual = deck.peekFront();
        assertEquals(expected, actual);
    }

    /* peekFront tests */

    @Test
    public void peekFront_emptyDeck_throwsException() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(Deck.emptyDeckError);

        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(2);
        deck.pushBack(3);

        deck.popFront();
        deck.popFront();
        deck.popFront();

        deck.peekFront();
    }

    /* pushBack tests */

    @Test
    public void pushBack_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(1);
        deck.pushBack(1);

        int expected = 3;
        int actual = deck.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void pushBack_dataTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(2);
        deck.pushBack(3);

        int expected = 1;
        int actual = deck.peekFront();
        assertEquals(expected, actual);
    }

    /* popBack tests */

    @Test
    public void popBack_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(2);
        deck.pushBack(3);

        deck.popBack();

        int expected = 2;
        int actual = deck.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void popBack_sizeTest_negativeSize() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(2);
        deck.pushBack(3);

        deck.popBack();
        deck.popBack();
        deck.popBack();
        deck.popBack();

        int expected = 0;
        int actual = deck.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void popBack_dataTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.pushBack(1);
        deck.pushBack(2);
        deck.pushBack(3);

        deck.popBack();

        int expected = 2;
        int actual = deck.peekBack();
        assertEquals(expected, actual);
    }
}
