package DoublyLinkedLists;

public class DoubleLinkedList {
    DoubleLinkedListElement head;
    DoubleLinkedListElement tail;

    public void insert(Object data) {
        DoubleLinkedListElement newNode = new DoubleLinkedListElement(null, data, head);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        head.next = newNode;
        head = newNode;
    }

    public void append(Object data) {
        DoubleLinkedListElement newNode = new DoubleLinkedListElement(tail, data, null);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.prev = newNode;
        head = newNode;
    }
}
