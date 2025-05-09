// THIS GOES IN YOUR MAIN CLASS TO TEST YOUR CODE:
// -----------------------------------------------

public class Main {

    public static void main(String[] args) {

        Stack myStack = new Stack(2);

        System.out.println("Before push():");
        System.out.println("--------------");
        myStack.getTop();
        myStack.getHeight();

        System.out.println("\nStack:");
        myStack.printStack();

        myStack.push(1);

        System.out.println("\n\nAfter push():");
        System.out.println("-------------");
        myStack.getTop();
        myStack.getHeight();

        System.out.println("\nStack:");
        myStack.printStack();
        
        /*
            EXPECTED OUTPUT:
    
			Before push():
			--------------
			Top: 2
			Height: 1

			Stack:
			2


			After push():
			-------------
			Top: 1
			Height: 2

			Stack:
			1
			2

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

}

