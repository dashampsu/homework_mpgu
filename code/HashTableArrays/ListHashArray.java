package HashTableArrays;
import DynamicArrays.*;

public class ListHashArray {
    int TABLE_SIZE = 9;
    DynamicArray<TableObject>[] table;

    protected String outOfBoundsException = "The key is out of bounds.";

    public ListHashArray(int size) {

        TABLE_SIZE = size;
        table = new DynamicArray[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new DynamicArray<TableObject>();
        }
    }

    public void insert(int data) {
        int keyIndex = data % TABLE_SIZE;
        TableObject newObject = new TableObject(keyIndex, data);
        table[keyIndex].add(newObject);
    }

    public void remove(int data) {
        int index = data % TABLE_SIZE;
        for (int i = 0; i < table[index].getsize(); i++) {
            if (data == table[index].get(i).data) {
                table[index].remove(i);
            }
        }
    }

    public DynamicArray<TableObject> get(int data) {
        int index = data % TABLE_SIZE;
        return table[index];
    }

    public void printAll() {
        int counter = 0;
        for (DynamicArray<TableObject> list : table) {
            System.out.println("HashTable[" + counter + "]:");

            for (int i = 0; i < list.getsize(); i++) {
                System.out.println(list.get(i).getData());
            }

            counter++;
        }
    }
}
