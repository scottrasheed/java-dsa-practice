import java.util.ArrayList;
import java.util.LinkedList;

class BinarySearchTree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        if (root != null) {
            new Traverse(root);
        }

        return results;
    }

    public boolean isValidBST() {
        ArrayList<Integer> inorder = DFSInOrder();

        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
        }

        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        testSingleNodeTree();
        testValidBST();
        testValidBSTWithDeepLeftSubtree();
        testValidBSTWithDeepRightSubtree();
        testBalancedBST();
    }

    private static void testSingleNodeTree() {
        System.out.println("\n----- Test: Single Node Tree -----");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        printIsValidBST(bst);
    }

    private static void testValidBST() {
        System.out.println("\n----- Test: Valid BST -----");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        printIsValidBST(bst);
    }

    private static void testValidBSTWithDeepLeftSubtree() {
        System.out.println("\n----- Test: BST With Deep Left Subtree -----");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(8);
        bst.insert(6);
        bst.insert(4);
        bst.insert(2);
        printIsValidBST(bst);
    }

    private static void testValidBSTWithDeepRightSubtree() {
        System.out.println("\n----- Test: BST With Deep Right Subtree -----");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(12);
        bst.insert(14);
        bst.insert(16);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private static void testBalancedBST() {
        System.out.println("\n----- Test: Balanced BST -----");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        printIsValidBST(bst);
    }

    private static void printIsValidBST(BinarySearchTree bst) {
        System.out.println("Is valid BST: " + bst.isValidBST());
    }
}

// ----------------------------------------------------------
// EXPECTED OUTPUT:
//
// ----- Test: Single Node Tree -----
// Is valid BST: true
//
// ----- Test: Valid BST -----
// Is valid BST: true
//
// ----- Test: BST With Deep Left Subtree -----
// Is valid BST: true
//
// ----- Test: BST With Deep Right Subtree -----
// Is valid BST: true
//
// ----- Test: Balanced BST -----
// Is valid BST: true
// ----------------------------------------------------------
