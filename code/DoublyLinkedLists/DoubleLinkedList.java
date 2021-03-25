package DoublyLinkedLists;

public class DoubleLinkedList<T> {
    public DoubleLinkedListElement<T> head;
    public DoubleLinkedListElement<T> tail;
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

    public int getSize() {
        return size;
    }

    public void insert(T data) {
        // inserts node before the first node

        DoubleLinkedListElement<T> newNode = new DoubleLinkedListElement<T>(null, data, head);

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

    public void append(T data) {
        // inserts node after the last node

        DoubleLinkedListElement<T> newNode = new DoubleLinkedListElement<T>(tail, data, null);

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

    public Boolean contains(T data) {
        boolean contains = false;
        DoubleLinkedListElement<T> iterator = head;

        while (iterator != null && iterator.elementGetNext() != null) {
            if (iterator.data.equals(data)) {
                contains = true;
            }
            iterator = iterator.elementGetNext();
        }

        if (!isEmpty() && iterator.data.equals(data)) {
            contains = true;
        }
        return contains;
    }

    public void insertAfter(DoubleLinkedListElement<T> afterNode, T data) {
        DoubleLinkedListElement<T> newNode = new DoubleLinkedListElement<T>(data);
        size++;

        if (!contains(afterNode.data)) {
            throw new RuntimeException(elementNotFoundError);
        }

        newNode.next = afterNode.next;
        newNode.prev = afterNode;

        if (afterNode == tail) {
            append(data);
        }
        else {
            afterNode.next = newNode;
            newNode.next.prev = newNode;
        }
    }

    public void insertBefore(DoubleLinkedListElement<T> beforeNode, T data) {
        DoubleLinkedListElement<T> newNode = new DoubleLinkedListElement<T>(data);
        size++;

        if (!contains(beforeNode.data)) {
            throw new RuntimeException(elementNotFoundError);
        }


        newNode.prev = beforeNode.prev;
        beforeNode.prev = newNode;
        newNode.next = beforeNode;

        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        } else {
            insert(data);
        }
    }

    public void removeElementByValue(T value) {
        DoubleLinkedListElement<T> iterator = head;

        while (iterator.elementGetNext() != null) {
            if (iterator.data == value) {

                // если это первый элемент
                if(iterator.elementGetPrev() == null) {
                    head = head.next;
                    head.prev = null;
                    size--;
                    return;
                }

                // если это последний элемент
                if(iterator.elementGetNext() == null) {
                    head = head.prev;
                    head.next = null;
                    size--;
                    return;
                }

                // если это элемент посередине

                iterator.elementGetPrev().next = iterator.next;
                size--;
                return;
            }
            iterator = iterator.next;
        }


        // если последний элемент

        if (iterator.data == value) {
            iterator.elementGetPrev().next = iterator.next;
            size--;
            return;
        }

        throw new RuntimeException(elementNotFoundError);
    }

    public void removeElement(int id) {
        DoubleLinkedListElement<T> temp = head;
        temp.next = head.next;
        int counter = 0;

        while (temp.next != null && counter != id) {
            // iterating over the list

            temp = temp.next;
            counter++;
        }

        if (counter == id) {
            // if element is found

            if (temp.prev == null) {
                // if it's the first element

                head = temp.next;
                head.prev = null;
                return;
            }

            if (temp.next == null) {
                // if it's the last element

                tail = temp.prev;
                tail.next = null;
                return;
            }

            DoubleLinkedListElement<T> prevElement = temp.prev;
            DoubleLinkedListElement<T> nextElement = temp.next;
            nextElement.prev = prevElement;
            prevElement.next = nextElement;
            size--;
            return;
        }

        throw new IllegalArgumentException(outOfRangeError);
    }


    public T getValueByIndex(int index) {

        if (index < 0 || index > size) {
            throw new RuntimeException(outOfRangeError);
        }

        int currentIndex = 0;

        DoubleLinkedListElement<T> iterator = head;

        while (currentIndex != index) {
            iterator = iterator.elementGetNext();
            currentIndex++;
        }

        return iterator.data;
    }

    public void setValueByIndex(int index, T data) {

        if (index < 0 || index > size) {
            throw new RuntimeException(outOfRangeError);
        }

        int currentIndex = 0;

        DoubleLinkedListElement<T> iterator = head;

        while (currentIndex != index) {
            iterator = iterator.elementGetNext();
            currentIndex++;
        }

        iterator.setData(data);
    }

    public DoubleLinkedListElement<T> getNodeByIndex(int index) {

        if (index < 0 || index > size) {
            throw new RuntimeException(outOfRangeError);
        }

        int currentIndex = 0;

        DoubleLinkedListElement<T> iterator = head;

        while (currentIndex != index) {
            iterator = iterator.elementGetNext();
            currentIndex++;
        }

        return iterator;
    }

    public void setNodeByIndex(int index, DoubleLinkedListElement<T> node) {

        if (index < 0 || index > size) {
            throw new RuntimeException(outOfRangeError);
        }

        int currentIndex = 0;

        DoubleLinkedListElement<T> iterator = head;

        while (currentIndex != index) {
            iterator = iterator.elementGetNext();
            currentIndex++;
        }

        if (iterator.prev == null) {
            head = iterator.next;
            return;
        }

        if (iterator.next == null) {
            tail = iterator;
            return;
        }

        iterator.prev.next = node;
    }

    public int findFirstOccurance(T data) {
        // возвращает индекс первого вхождения

        if (size < 1) {
            throw new RuntimeException(listIsEmptyError);
        }

        DoubleLinkedListElement<T> iterator = head;
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

    public DoubleLinkedListElement<T> findFirstNodeByValue(T data) {
        // возвращает индекс первого вхождения

        if (size < 1) {
            throw new RuntimeException(listIsEmptyError);
        }

        DoubleLinkedListElement<T> iterator = head;
        iterator.elementSetNext(head.elementGetNext());

        while (iterator.elementGetNext() != null) {

            if (iterator.data.equals(data)) {
                return iterator;
            }

            iterator = iterator.elementGetNext();
        }

        if (iterator.data == data) {
            return iterator;
        }

        throw new RuntimeException(elementNotFoundError);
    }

    public void pop() {
        // deletes the last element

        if (tail == null) {
            return;
        }

        tail = tail.prev;
    }

    public T getTail() {
        // deletes the last element

        return tail.data;
    }

    public void printAll() {
        if (isEmpty()) {
            throw new RuntimeException(listIsEmptyError);
        }

        DoubleLinkedListElement<T> iterator = head;
        iterator.elementSetNext(head.elementGetNext());

        while (iterator.elementGetNext() != null) {
            System.out.print(iterator.getData() + " ");
            iterator = iterator.elementGetNext();
        }
        System.out.println(iterator.getData());
    }
}
