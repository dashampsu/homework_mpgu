package HashTableArrays;
import HashTable.TableObject;
import DynamicArrays.*;

public class ListHashArray {
    int TABLE_SIZE = 9;
    DynamicArray[] table;

    protected String outOfBoundsException = "The key is out of bounds.";

    public ListHashArray(int size) {

        TABLE_SIZE = size;
        table = new DynamicArray[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new DynamicArray();
        }
    }

    public void insert(int data) {
        int keyIndex = data % TABLE_SIZE;
        HashTable.TableObject newObject = new HashTable.TableObject(keyIndex, data);
        table[keyIndex].add(newObject);
    }

    public void remove(int key) {

        if (key > TABLE_SIZE || key < 0) {
            throw new RuntimeException(outOfBoundsException);
        }

        table[key] = new DynamicArray();
    }

    public DynamicArray<HashTable.TableObject> get(int key) {

        if (key > TABLE_SIZE || key < 0) {
            throw new RuntimeException(outOfBoundsException);
        }

        return table[key];
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
