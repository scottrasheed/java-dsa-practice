class BinarySearchTree {

    class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = insertRec(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = insertRec(currentNode.right, value);
        }

        return currentNode;
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
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

        System.out.println(myBST.minValue(myBST.root));         // Output: 18
        System.out.println(myBST.minValue(myBST.root.right));   // Output: 52
    }
}

/*
Expected Output:
18
52
*/
