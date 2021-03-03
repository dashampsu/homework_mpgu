import DoublyLinkedLists.DoubleLinkedList;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList listy = new DoubleLinkedList();

        listy.append(1); // 1
        listy.append(2); // 1 2
        listy.append(3); // 1 2 3

        listy.printAll(); // 3 2 1 starting from end

        DoubleLinkedList dada = new DoubleLinkedList();

        dada.insert(1); // 1
        dada.insert(2); // 2 1
        dada.insert(3); // 3 2 1

        dada.printAll();
    }
}
