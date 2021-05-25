package Graphs;
import org.junit.jupiter.api.Test;

public class GraphTest {

    @Test
    public void init_test() {
        Graph graph = new Graph(5);
    }

    @Test
    public void add_positive() {
        Graph graph = new Graph(5);
        graph.add(5, 6);
    }

}
