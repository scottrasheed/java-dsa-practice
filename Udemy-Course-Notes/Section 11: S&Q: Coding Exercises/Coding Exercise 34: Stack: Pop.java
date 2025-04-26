public class Stack {

    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(2);  // Initialize the stack with the value 2
        myStack.push(1);               // Push the value 1 onto the stack

        // (2) Items - Returns 1 Node
        System.out.println(myStack.pop().value);  // Pop the top item and print it
        // (1) Item - Returns 2 Node
        System.out.println(myStack.pop().value);  // Pop the next item and print it
        // (0) Items - Returns null
        System.out.println(myStack.pop());  // Try to pop from an empty stack, expect null


        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            null
        */
    }
}
