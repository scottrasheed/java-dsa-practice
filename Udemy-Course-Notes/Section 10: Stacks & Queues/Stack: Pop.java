// THIS GOES IN YOUR MAIN CLASS TO TEST YOUR CODE:
// -----------------------------------------------


public class Main {

    public static void main(String[] args) {

        Stack myStack = new Stack(2);
        myStack.push(1);

        // (2) Items - Returns 1 Node
        System.out.println(myStack.pop().value);
        // (1) Item - Returns 2 Node
        System.out.println(myStack.pop().value);
        // (0) Items - Returns null
        System.out.println(myStack.pop());


        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            null

        */

    }

}





// THIS CODE GOES IN YOUR STACK CLASS:
// -----------------------------------
      

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

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if(height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

}

