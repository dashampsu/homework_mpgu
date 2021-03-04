package DoublyLinkedLists;

public class DoubleLinkedList {
    DoubleLinkedListElement head;
    DoubleLinkedListElement tail;
    int size = 0;

    // ...... ошибки ......
    public static String listIsEmptyError = "список пустой";
    public static String elementNotFoundError = "элемент не найден";
    public static String outOfRangeError = "индекс за границами массива";

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

    public int getSize() {
        return size;
    }

    public int getValueByIndex(int index) {

        if (index < 0 || index > size) {
            throw new RuntimeException(outOfRangeError);
        }

        int currentIndex = 0;

        DoubleLinkedListElement iterator = head;

        while (currentIndex != index) {
            iterator = iterator.elementGetNext();
            currentIndex++;
        }

        return iterator.data;
    }

    public void setValueByIndex(int index, int data) {

        if (index < 0 || index > size) {
            throw new RuntimeException(outOfRangeError);
        }

        int currentIndex = 0;

        DoubleLinkedListElement iterator = head;

        while (currentIndex != index) {
            iterator = iterator.elementGetNext();
            currentIndex++;
        }

        iterator.setData(data);
    }

    public int findFirstOccurance(int data) {
        // возвращает индекс первого вхождения

        if (size < 1) {
            throw new RuntimeException(listIsEmptyError);
        }

        DoubleLinkedListElement iterator = head;
        iterator.elementSetNext(head.elementGetNext());

        int index = 0;

        while (iterator.elementGetNext() != null) {

            if (iterator.data == data) {
                return index;
            }

            iterator = iterator.elementGetNext();
            index++;
        }

        if (iterator.data == data) {
            return index;
        }

        throw new RuntimeException(elementNotFoundError);
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
