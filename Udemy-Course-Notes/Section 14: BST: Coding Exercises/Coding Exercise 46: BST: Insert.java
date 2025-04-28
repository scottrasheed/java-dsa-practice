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

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node current = root;
        while (true) {
            if (value == current.value) {
                // Value already exists, don't insert duplicates
                return false;
            }

            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                    return true;
                }
                current = current.left;
            } else { // value > current.value
                if (current.right == null) {
                    current.right = newNode;
                    return true;
                }
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        /*
            THE LINES ABOVE CREATE THIS TREE:
                         2
                        / \
                       1   3
        */

        System.out.println("Root: " + myBST.getRoot().value);
        System.out.println("\nRoot->Left: " + myBST.getRoot().left.value);
        System.out.println("\nRoot->Right: " + myBST.getRoot().right.value);

        /*
            EXPECTED OUTPUT:
            ----------------
            Root: 2

            Root->Left: 1

            Root->Right: 3
        */
    }
}
