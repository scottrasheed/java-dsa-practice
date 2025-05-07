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
    
    
    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
    
    
     private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }
    public boolean rContains(int value) { return rContains(root, value); }
    
    
    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }    


    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
    
private Node deleteNode(Node currentNode, int value) {
    if (currentNode == null) return null;

    if (value < currentNode.value) {
        currentNode.left = deleteNode(currentNode.left, value);
    } else if (value > currentNode.value) {
        currentNode.right = deleteNode(currentNode.right, value);
    } else {
        // Node to delete found
        if (currentNode.left == null && currentNode.right == null) {
            return null; // No children
        } else if (currentNode.left == null) {
            return currentNode.right; // One child (right)
        } else if (currentNode.right == null) {
            return currentNode.left; // One child (left)
        } else {
            // Two children: find the minimum in the right subtree
            int minValue = minValue(currentNode.right);
            currentNode.value = minValue;
            currentNode.right = deleteNode(currentNode.right, minValue);
        }
    }

    return currentNode;
}

    
    public void deleteNode(int value) { root = deleteNode(root, value); }  
    
}

public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        /*
               2
              / \
             1   3
        */

        System.out.println( "Root: " + myBST.getRoot().value );
        System.out.println( "Root->Left: " + myBST.getRoot().left.value );
        System.out.println( "Root->Right: " + myBST.getRoot().right.value );


        myBST.deleteNode(2);

        /*
               3
              / \
             1  null
        */


        System.out.println( "\nRoot: " + myBST.getRoot().value );
        System.out.println( "Root->Left: " + myBST.getRoot().left.value );
        System.out.println( "Root->Right: " + myBST.getRoot().right );
        
        
        /*
            EXPECTED OUTPUT:
            ----------------
			Root: 2
			Root->Left: 1
			Root->Right: 3

			Root: 3
			Root->Left: 1
			Root->Right: null

        */

    }

}
