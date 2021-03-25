import DoublyLinkedLists.*;
import Stack.*;
import Queue.*;
import Deck.*;

public class Main {

    public static void main(String[] args) {
        Deck<Integer> deck = new Deck<Integer>();

        deck.push_back(10);
        deck.push_back(20);
        deck.push_back(30);
        deck.printAll();

    }
}
