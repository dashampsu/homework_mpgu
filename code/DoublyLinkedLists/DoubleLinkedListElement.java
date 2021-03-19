package DoublyLinkedLists;

public class DoubleLinkedListElement<T> {
    DoubleLinkedListElement<T> next;
    DoubleLinkedListElement<T> prev;
    T data;

    DoubleLinkedListElement() {

    }

    public DoubleLinkedListElement(T data) {
        this.data = data;
    }

    DoubleLinkedListElement(DoubleLinkedListElement<T> prev, T data, DoubleLinkedListElement<T> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleLinkedListElement<T> elementGetNext() {
        return next;
    }

    public void elementSetNext(DoubleLinkedListElement<T> next) {
        this.next = next;
    }

    public DoubleLinkedListElement<T> elementGetPrev() {
        return prev;
    }

    public void elementSetPrev(DoubleLinkedListElement<T> prev) {
        this.prev = prev;
    }
}
