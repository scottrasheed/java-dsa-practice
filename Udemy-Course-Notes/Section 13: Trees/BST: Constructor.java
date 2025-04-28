// THIS GOES IN YOUR MAIN CLASS TO TEST YOUR CODE:
// -----------------------------------------------



public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();
        
        
        // ROOT MUST BE PUBLIC FOR THIS LINE TO WORK
        System.out.println("Root: " + myBST.root);


        /*
            EXPECTED OUTPUT:
            ----------------
            Root: null

        */

    }

}





// THIS CODE GOES IN YOUR BST CLASS:
// ---------------------------------
      



public class BinarySearchTree {

    public Node root;

	class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

}
