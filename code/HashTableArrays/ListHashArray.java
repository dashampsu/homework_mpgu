package HashTableArrays;
import DynamicArrays.*;

public class ListHashArray {
    int TABLE_SIZE = 9;
    DynamicArray<TableObject> table;

    public ListHashArray(int size) {

        TABLE_SIZE = size;
        table = new DynamicArray<TableObject>(TABLE_SIZE);
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

        table.insert(keyIndex, newObject);
    }

    public void remove(int data) {
        int index = data % TABLE_SIZE;
        if (table.get(index).data == data) {
            table.remove(index);
        } else {
            for (int i = index; i < table.getsize(); i++) {
                if (table.get(i) != null && table.get(i).data == data) {
                    table.remove(i);
                    return;
                }
            }
        }
    }

    public TableObject get(int data) {
        int index = data % TABLE_SIZE;
        if (table.get(index).data == data) {
            return table.get(index);
        } else {
            for (int i = 0; i < table.getsize(); i++) {

                if (table.get(i) != null && table.get(i).data == data) {
                    return table.get(i);
                }
            }
            return null;
        }
    }

    public void printAll() {
        for (int i = 0; i < table.getsize(); i++) {
            System.out.println("Item[" + i + "]: ");
            System.out.print(table.get(i));
        }
    }
}
