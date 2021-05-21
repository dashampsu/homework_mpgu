package Graphs;
import DynamicArrays.*;

public class Graph {
    DynamicArray<DynamicArray<Integer>> graph;
    int nodes;

    public Graph(int nodes) {
        this.nodes = nodes;
        graph = new DynamicArray<DynamicArray<Integer>>();

        for (int i = 0; i < nodes; i++) {
            graph.set(i, new DynamicArray<Integer>());
        }
    }


}
