package HashTable;
import DoublyLinkedLists.*;

import javax.swing.text.TabableView;

public class ListHashTable {
    int TABLE_SIZE = 9;
    DoubleLinkedList[] table = new DoubleLinkedList[TABLE_SIZE];

    public ListHashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new DoubleLinkedList();
        }
    }

    public void insert(int data) {
        int keyIndex = data % TABLE_SIZE;
        TableObject newObject = new TableObject(keyIndex, data);
        table[keyIndex].append(newObject);
    }

    public void remove(int key) {
        table[key] = new DoubleLinkedList();
    }

    public DoubleLinkedList<TableObject> get(int key) {
        return table[key];
    }

    public void printAll() {
        int counter = 0;
        for (DoubleLinkedList<TableObject> list : table) {
            System.out.println("HashTable[" + counter + "]:");

            for (int i = 0; i < list.getSize(); i++) {
                System.out.println(list.getValueByIndex(i).getData());
            }

            counter++;
        }
    }
}
