public class BinarySearchTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public Node getRoot() {
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();
        
        System.out.println("Root: " + myBST.getRoot());

        /*
            EXPECTED OUTPUT:
            ----------------
            Root: null
        */
    }
}
