import java.util.ArrayList;
import java.util.List;

class BinarySearchTree {

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

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderHelper(this.root, result);
        return result;
    }

    private void inorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.value);
        inorderHelper(node.right, result);
    }

    public boolean isBalanced() {
        return height(this.root) != -1;
    }

    private int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);

        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);

        return node;
    }
}
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Test: Convert an empty array
        System.out.println("\n----- Test: Convert Empty Array -----\n");
        checkBalancedAndCorrectTraversal(new int[]{}, Arrays.asList());

        // Test: Convert an array with one element
        System.out.println("\n----- Test: Convert Single Element Array -----\n");
        checkBalancedAndCorrectTraversal(new int[]{10}, Arrays.asList(10));

        // Test: Convert a sorted array with odd number of elements
        System.out.println("\n----- Test: Convert Sorted Array with Odd Number of Elements -----\n");
        checkBalancedAndCorrectTraversal(new int[]{1, 2, 3, 4, 5}, Arrays.asList(1, 2, 3, 4, 5));

        // Test: Convert a sorted array with even number of elements
        System.out.println("\n----- Test: Convert Sorted Array with Even Number of Elements -----\n");
        checkBalancedAndCorrectTraversal(new int[]{1, 2, 3, 4, 5, 6}, Arrays.asList(1, 2, 3, 4, 5, 6));

        // Test: Convert a large sorted array
        System.out.println("\n----- Test: Convert Large Sorted Array -----\n");
        checkBalancedAndCorrectTraversal(
                Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}).toArray(),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        );
    }

    private static void checkBalancedAndCorrectTraversal(int[] nums, List<Integer> expectedTraversal) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.sortedArrayToBST(nums);
        boolean isBalanced = bst.isBalanced();
        List<Integer> inorder = bst.inorderTraversal();
        System.out.println("Is balanced: " + isBalanced);
        System.out.println("Inorder traversal: " + inorder);
        System.out.println("Expected traversal: " + expectedTraversal);
        if (isBalanced && inorder.equals(expectedTraversal)) {
            System.out.println("PASS: Tree is balanced and inorder traversal is correct.\n");
        } else {
            System.out.println("FAIL: Tree is either not balanced or inorder traversal is incorrect.\n");
        }
    }
}

/*
EXPECTED OUTPUT:

----- Test: Convert Empty Array -----

Is balanced: true
Inorder traversal: []
Expected traversal: []
PASS: Tree is balanced and inorder traversal is correct.

----- Test: Convert Single Element Array -----

Is balanced: true
Inorder traversal: [10]
Expected traversal: [10]
PASS: Tree is balanced and inorder traversal is correct.

----- Test: Convert Sorted Array with Odd Number of Elements -----

Is balanced: true
Inorder traversal: [1, 2, 3, 4, 5]
Expected traversal: [1, 2, 3, 4, 5]
PASS: Tree is balanced and inorder traversal is correct.

----- Test: Convert Sorted Array with Even Number of Elements -----

Is balanced: true
Inorder traversal: [1, 2, 3, 4, 5, 6]
Expected traversal: [1, 2, 3, 4, 5, 6]
PASS: Tree is balanced and inorder traversal is correct.

----- Test: Convert Large Sorted Array -----

Is balanced: true
Inorder traversal: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
Expected traversal: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
PASS: Tree is balanced and inorder traversal is correct.
*/
