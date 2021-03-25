package Deck;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DeckTests {

    @Test
    public void deck_init_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        int expected = 0;
        int actual = deck.getSize();
        assertEquals(expected, actual);
    }

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
}
