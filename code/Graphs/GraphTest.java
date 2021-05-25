package Graphs;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class GraphTest {

    @Test
    public void init_test() {
        Graph graph = new Graph(5);
    }

    @Test
    public void add_positive() {
        Graph graph = new Graph(10);
        graph.add(1, 2);
        graph.add(1, 4);
        graph.add(1, 5);
        graph.add(7, 3);
        graph.delete(7, 3);

        int expected = 2;
        int actual = graph.get(1).get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get_positive() {
        Graph graph = new Graph(10);
        graph.add(1, 2);
        graph.add(1, 4);
        graph.add(1, 5);
        graph.add(7, 3);
        graph.delete(7, 3);

        int expected = 2;
        int actual = graph.get(1).get(0);
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void get_outOfBounds_ReturnNull() {
//        Graph graph = new Graph(10);
//        graph.add(1, 2);
//        graph.add(1, 4);
//        graph.add(1, 5);
//        graph.add(7, 3);
//        graph.delete(7, 3);
//
//        Object expected = null;
//        Object actual = graph.get(10);
//        Assert.assertEquals(expected, actual);
//    }

}
