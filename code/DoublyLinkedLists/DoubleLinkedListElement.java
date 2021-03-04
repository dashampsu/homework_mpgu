package DoublyLinkedLists;

public class DoubleLinkedListElement {
    DoubleLinkedListElement next;
    DoubleLinkedListElement prev;
    int data;

    DoubleLinkedListElement() {

    }

    public DoubleLinkedListElement(int data) {
        this.data = data;
    }

    DoubleLinkedListElement(DoubleLinkedListElement prev, int data, DoubleLinkedListElement next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleLinkedListElement elementGetNext() {
        return next;
    }

    public void elementSetNext(DoubleLinkedListElement next) {
        this.next = next;
    }

    public DoubleLinkedListElement elementGetPrev() {
        return prev;
    }

    public void elementSetPrev(DoubleLinkedListElement prev) {
        this.prev = prev;
    }
}
