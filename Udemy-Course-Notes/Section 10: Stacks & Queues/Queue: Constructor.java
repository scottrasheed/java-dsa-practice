// THIS GOES IN YOUR MAIN CLASS TO TEST YOUR CODE:
// -----------------------------------------------


public class Main {

    public static void main(String[] args) {

        Queue myQueue = new Queue(4);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();

        System.out.println("\nQueue:");
        myQueue.printQueue();

        /*
            EXPECTED OUTPUT:
            ----------------
            First: 4
            Last: 4
            Length: 1
            
            Queue:
            4

        */

    }

}





// THIS CODE GOES IN YOUR QUEUE CLASS:
// -----------------------------------
      

public class Queue {

    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getFirst() {
        if (first == null) {
            System.out.println("First: null");
        } else {
            System.out.println("First: " + first.value);
        }
    }

    public void getLast() {
        if (last == null) {
            System.out.println("Last: null");
        } else {
            System.out.println("Last: " + last.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

}

