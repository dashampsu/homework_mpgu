package HashTable;
import DoublyLinkedLists.*;

public class ListHashTable {
    int TABLE_SIZE;
    DoubleLinkedList[] table;

    protected String outOfBoundsException = "The key is out of bounds.";

    public ListHashTable(int size) {
        TABLE_SIZE = size;
        table = new DoubleLinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new DoubleLinkedList();
        }
    }

    public void insert(int data) {
        int keyIndex = data % TABLE_SIZE;
        TableObject newObject = new TableObject(keyIndex, data);
        table[keyIndex].append(newObject);
    }

    public void remove(int data) {
        int index = data % TABLE_SIZE;

        table[index].removeElementByValue(data);
    }

    public DoubleLinkedList<TableObject> get(int data) {
        int index = data % TABLE_SIZE;
        return table[index];
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
