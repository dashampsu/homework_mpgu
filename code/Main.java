import DoublyLinkedLists.DoubleLinkedList;
import DoublyLinkedLists.DoubleLinkedListElement;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList listy = new DoubleLinkedList();

        listy.append(1); // 1
        listy.append(2); // 1 2
        listy.append(3); // 1 2 3

        listy.printAll(); // 3 2 1 starting from end
        DoubleLinkedListElement node = listy.findFirstNodeByValue(3);
        DoubleLinkedListElement newnode = new DoubleLinkedListElement(22);

        listy.insertBefore(node, 22);

        listy.printAll();
    }
}
