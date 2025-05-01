import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");

        System.out.println("\nGraph before removeEdge():");
        myGraph.printGraph();

        myGraph.removeEdge("A", "B");

        System.out.println("\nGraph after removeEdge():");
        myGraph.printGraph();

        /*
            EXPECTED OUTPUT:
            ----------------
            Graph before removeEdge():
            {A=[B, C], B=[A, C], C=[A, B]}
            
            Graph after removeEdge():
            {A=[C], B=[C], C=[A, B]}
        */
    }
}

class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }
}
