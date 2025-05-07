public class Main {

    // BinarySearchTree class implementation
    static class BinarySearchTree {

        // Node class to represent each node in the tree
        class Node {
            int value;
            Node left, right;

            public Node(int value) {
                this.value = value;
                left = right = null;
            }
        }

        private Node root;

        public BinarySearchTree() {
            root = null;
        }

        // Insert method to add values to the BST
        public void insert(int value) {
            root = insertRec(root, value);
        }

        // Helper recursive method to insert a new value
        private Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }

            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }

            return root;
        }

        // Method to check if a value is present in the tree
        public boolean rContains(int value) {
            return rContainsRec(root, value);
        }

        // Recursive method to check if value is present in the tree
        private boolean rContainsRec(Node root, int value) {
            if (root == null) {
                return false;
            }
            if (root.value == value) {
                return true;
            }

            if (value < root.value) {
                return rContainsRec(root.left, value);
            } else {
                return rContainsRec(root.right, value);
            }
        }
    }

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("\nBST Contains 27:");
        System.out.println( myBST.rContains(27));

        System.out.println("\nBST Contains 17:");
        System.out.println( myBST.rContains(17));
    }
}

/*
Expected Output:
BST Contains 27:
true

BST Contains 17:
false
*/
