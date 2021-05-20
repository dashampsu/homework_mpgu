package HashTableArrays;
import HashTable.TableObject;
import DynamicArrays.*;

public class ListHashArray {
    int TABLE_SIZE = 9;
    DynamicArray[] table = new DynamicArray[TABLE_SIZE];

    public ListHashArray() {
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
        table[key] = new DynamicArray();
    }

    public DynamicArray<HashTable.TableObject> get(int key) {
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
