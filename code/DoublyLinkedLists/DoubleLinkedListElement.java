package DoublyLinkedLists;

public class DoubleLinkedListElement {
    DoubleLinkedListElement next;
    DoubleLinkedListElement prev;
    Object data;

    DoubleLinkedListElement() {

    }

    DoubleLinkedListElement(Object data) {
        this.data = data;
    }

    DoubleLinkedListElement(DoubleLinkedListElement prev, Object data) {
        this.prev = prev;
        this.data = data;
    }

    DoubleLinkedListElement(DoubleLinkedListElement prev, Object data, DoubleLinkedListElement next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
