import HashTable.*;

public class Main {

    public static void main(String[] args) {
        ListHashTable table = new ListHashTable();

        table.insert(9);
        table.insert(18);
        table.printAll();
        table.remove(0);
        table.printAll();
    }
}
