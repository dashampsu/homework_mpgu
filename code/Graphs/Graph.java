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

    public void add(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public void delete(int source, int destination)
    {
        for (int i = 0; i < graph.get(destination).getsize(); i++)
        {
            if (graph.get(destination).get(i).equals(source))
            {
                graph.get(destination).remove(i);
                break;
            }
        }
        for (int i = 0; i < graph.get(source).getsize(); i++)
        {
            if (graph.get(source).get(i) == destination)
            {
                graph.get(source).remove(i);
                break;
            }
        }
    }


}
