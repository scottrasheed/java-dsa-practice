package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // Creating an instance of the Graph class
        Graph myGraph = new Graph();
        
        // Adding vertices to the graph
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        
        // Printing the graph
        System.out.println("\nGraph:");
        myGraph.printGraph();

        /*
            EXPECTED OUTPUT:
            ----------------
            Graph:
            {A=[], B=[]}

        */

    }

}

// Graph class to represent a graph using an adjacency list
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

}
