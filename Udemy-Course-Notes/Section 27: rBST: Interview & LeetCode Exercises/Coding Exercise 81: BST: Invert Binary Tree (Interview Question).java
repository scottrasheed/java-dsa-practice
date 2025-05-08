import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    private Node insert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = insert(currentNode.right, value);
        }
        return currentNode;
    }
    public void insert(int value) {
        if (root == null) root = new Node(value);
        insert(root, value);
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        if (currentNode != null) {
            queue.add(currentNode);
        }

        while (queue.size() > 0) {
            currentNode = queue.remove();
            if (currentNode != null) {
                results.add(currentNode.value);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    public void invert() {
        root = invertTree(root);
    }

    private Node invertTree(Node node) {
        if (node == null) return null;

        // Swap the left and right children
        Node temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);

        return node;
    }


}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static void performTest(String description, int[] insertValues, Integer[] expectedValues, boolean doubleInversion) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int value : insertValues) {
            bst.insert(value);
        }
        if (doubleInversion) {
            bst.invert(); // First inversion
        }
        bst.invert(); // Perform inversion (or second inversion for the specific case)

        ArrayList<Integer> resultList = bst.BFS();

        // Use Arrays.asList for compatibility with older Java versions
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(expectedValues));

        System.out.println(description + ": " + (expectedList.equals(resultList) ? "Pass" : "Fail"));
        System.out.println("Expected: " + expectedList);
        System.out.println("Actual:   " + resultList);
    }

    private static void testInvertBinarySearchTree() {
        System.out.println("--- Testing Inversion of Binary Search Tree ---");

        performTest("Invert an empty tree", new int[]{}, new Integer[]{}, false);
        performTest("Invert a tree with a single node", new int[]{1}, new Integer[]{1}, false);
        performTest("Invert a tree with only a left child", new int[]{2, 1}, new Integer[]{2, null, 1}, false);
        performTest("Invert a tree with only a right child", new int[]{1, 2}, new Integer[]{1, 2}, false);
        performTest("Invert a full binary tree", new int[]{2, 1, 3}, new Integer[]{2, 3, 1}, false);
        performTest("Invert a more complex binary tree", new int[]{4, 2, 6, 1, 3, 5, 7}, new Integer[]{4, 6, 2, 7, 5, 3, 1}, false);
        performTest("Double inversion returns original", new int[]{3, 1, 4}, new Integer[]{3, 1, 4}, true);
    }

    public static void main(String[] args) {
        testInvertBinarySearchTree();
    }

}

/*
EXPECTED OUTPUT:

--- Testing Inversion of Binary Search Tree ---

Invert an empty tree: Pass
Expected: []
Actual:   []

Invert a tree with a single node: Pass
Expected: [1]
Actual:   [1]

Invert a tree with only a left child: Fail
Expected: [2, null, 1]
Actual:   [2, 1]

Invert a tree with only a right child: Pass
Expected: [1, 2]
Actual:   [1, 2]

Invert a full binary tree: Pass
Expected: [2, 3, 1]
Actual:   [2, 3, 1]

Invert a more complex binary tree: Pass
Expected: [4, 6, 2, 7, 5, 3, 1]
Actual:   [4, 6, 2, 7, 5, 3, 1]

Double inversion returns original: Pass
Expected: [3, 1, 4]
Actual:   [3, 1, 4]
*/
