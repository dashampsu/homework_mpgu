package HashTable;
import DoublyLinkedLists.*;

class TableObject {
    int key;
    int data;

    public TableObject() {

    }

    public TableObject(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

public class ListHashTable {
    DoubleLinkedList[] table = new DoubleLinkedList[9];

    public void insert(int data) {
        int keyIndex = data % 9;

        if (table[keyIndex] == null) {
            table[keyIndex] = new DoubleLinkedList();
        }

        table[keyIndex].append(data);
        table[keyIndex].printAll();
    }
}
