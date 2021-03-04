package DoublyLinkedLists;

public class DoubleLinkedList {
    DoubleLinkedListElement head;
    DoubleLinkedListElement tail;
    int size = 0;

    // ...... ошибки ......
    public static String listIsEmptyError = "список пустой";

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

    public Boolean contains(int data) {
        boolean contains = false;
        DoubleLinkedListElement iterator = head;

        while (iterator != null && iterator.elementGetNext() != null) {
            if (iterator.data == data) {
                contains = true;
            }
            iterator = iterator.elementGetNext();
        }

        if (!isEmpty() && iterator.data == data) {
            contains = true;
        }
        return contains;
    }

    public void printAll() {
        if (isEmpty()) {
            throw new RuntimeException(listIsEmptyError);
        }

        DoubleLinkedListElement iterator = head;
        iterator.elementSetNext(head.elementGetNext());

        while (iterator.elementGetPrev() != null) {
            System.out.print(iterator.getData() + " ");
            iterator = iterator.elementGetPrev();
        }
        System.out.println(iterator.getData());
    }
}
