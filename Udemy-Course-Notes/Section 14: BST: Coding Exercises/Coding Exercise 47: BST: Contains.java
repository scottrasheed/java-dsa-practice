public class BinarySearchTree {

    private Node root;

    // Node class inside BinarySearchTree
    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // Method to get the root node
    public Node getRoot() {
        return root;
    }

    // Method to insert a new value into the tree
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

    // Method to check if a value is in the tree
    public boolean contains(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.value) {
                return true; // value found
            }
            if (value < current.value) {
                current = current.left; // move left
            } else {
                current = current.right; // move right
            }
        }
        return false; // value not found
    }

    // Main method where the execution begins
    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        // Inserting nodes into the BST
        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        // Checking if certain values are contained in the tree
        System.out.println("BST Contains 27:");
        System.out.println(myBST.contains(27));  // Expected Output: true

        System.out.println("\nBST Contains 17:");
        System.out.println(myBST.contains(17));  // Expected Output: false

        /*
            EXPECTED OUTPUT:
            ----------------
            BST Contains 27:
            true
            
            BST Contains 17:
            false
        */
    }
}
