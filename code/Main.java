import Graphs.*;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.add(1, 2);
        graph.add(1, 4);
        graph.add(1, 5);
        graph.add(7, 3);
        graph.printAll();
        graph.delete(7, 3);
        System.out.println();
        graph.printAll();
        System.out.println();
        graph.get(1).printAll();
    }
}
