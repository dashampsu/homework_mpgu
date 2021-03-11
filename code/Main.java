import DoublyLinkedLists.*;
import Stack.*;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.append(1);
        stack.append(2);
        stack.append(3);
        stack.append(4);

        stack.pop();
        stack.pop();
        stack.append(4);

        stack.printAll();
    }
}
