package HashTableArrays;
import DynamicArrays.*;

public class ListHashArray {
    int TABLE_SIZE = 9;
    DynamicArray<TableObject> table;

    public ListHashArray(int size) {

        TABLE_SIZE = size;
        table = new DynamicArray<TableObject>();
    }

    public void insert(int data) {
        int keyIndex = data % TABLE_SIZE;
        TableObject newObject = new TableObject(keyIndex, data);

        while (table.get(keyIndex) != null) {
            keyIndex += 1;

            if (keyIndex >= table.getsize()) {
                throw new RuntimeException("The table is full");
            }
        }
    }

    public void remove(int data) {
        int index = data % TABLE_SIZE;
        table.remove(index);
    }

    public TableObject get(int data) {
        int index = data % TABLE_SIZE;
        return table.get(index);
    }

    public void printAll() {
        for (int i = 0; i < table.getsize(); i++) {
            System.out.println("Item[" + i + "]: ");
            System.out.print(table.get(i));
        }
    }
}
