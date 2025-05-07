public class Main {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        public void insert(int value) {
            root = insert(root, value);
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

        public void deleteNode(int value) {
            root = deleteNode(root, value);
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
                    return null;
                } else if (currentNode.left == null) {
                    return currentNode.right;
                } else if (currentNode.right == null) {
                    return currentNode.left;
                } else {
                    int subTreeMin = minValue(currentNode.right);
                    currentNode.value = subTreeMin;
                    currentNode.right = deleteNode(currentNode.right, subTreeMin);
                }
            }

            return currentNode;
        }

        private int minValue(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node.value;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(2);
        myBST.insert(1);
        myBST.insert(3);

        System.out.println("\nBefore deletion:");
        System.out.println("Root: " + myBST.root.value);
        System.out.println("Root->Left: " + myBST.root.left.value);
        System.out.println("Root->Right: " + myBST.root.right.value);

        myBST.deleteNode(2);  // Deleting the root

        System.out.println("\nAfter deletion:");
        System.out.println("Root: " + myBST.root.value);
        System.out.println("Root->Left: " + (myBST.root.left != null ? myBST.root.left.value : "null"));
        System.out.println("Root->Right: " + (myBST.root.right != null ? myBST.root.right.value : "null"));
    }
}

/*
    Expected Output:
    ----------------
    Before deletion:
    Root: 2
    Root->Left: 1
    Root->Right: 3

    After deletion:
    Root: 3
    Root->Left: 1
    Root->Right: null
*/
