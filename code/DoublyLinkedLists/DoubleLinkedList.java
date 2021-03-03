package DoublyLinkedLists;

public class DoubleLinkedList {
    DoubleLinkedListElement head;
    DoubleLinkedListElement tail;
    int size = 0;

    public Boolean isEmpty() {
        if (size > 0) {
            return false;
        }

        return true;
    }

    public void insert(int data) {
        DoubleLinkedListElement newNode = new DoubleLinkedListElement(null, data, head);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void append(int data) {
        DoubleLinkedListElement newNode = new DoubleLinkedListElement(tail, data, null);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void printAll() {
        if (!isEmpty()) {
            DoubleLinkedListElement iterator = tail;
            iterator.elementSetPrev(tail.elementGetPrev());

            while (iterator.elementGetPrev() != null) {
                System.out.print(iterator.getData() + " ");
                iterator = iterator.elementGetPrev();
            }
            System.out.println(iterator.getData());
            return;
        }

        // если лист не пустой

        DoubleLinkedListElement iterator = head;
        iterator.elementSetNext(head.elementGetNext());

        while (iterator.elementGetNext() != null) {
            System.out.print(iterator.getData() + " ");
            iterator = iterator.elementGetNext();
        }
        System.out.print(iterator.getData());
    }
}
