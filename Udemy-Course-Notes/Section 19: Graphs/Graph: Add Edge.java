import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // Create an instance of the Graph class
        Graph myGraph = new Graph();

        // Add vertices to the graph
        myGraph.addVertex("A");
        myGraph.addVertex("B");

        // Print the graph before adding an edge
        System.out.println("\nGraph before addEdge():");
        myGraph.printGraph();

        // Add an edge between vertices A and B
        myGraph.addEdge("A", "B");

        // Print the graph after adding the edge
        System.out.println("\nGraph after addEdge():");
        myGraph.printGraph();

        /*
            EXPECTED OUTPUT:
            ----------------
            Graph before addEdge():
            {A=[], B=[]}

            Graph after addEdge():
            {A=[B], B=[A]}
        */
    }
}

class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    // Method to print the graph
    public void printGraph() {
        System.out.println(adjList);
    }

    // Method to add a vertex to the graph
    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    // Method to add an edge between two vertices
    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }
}
