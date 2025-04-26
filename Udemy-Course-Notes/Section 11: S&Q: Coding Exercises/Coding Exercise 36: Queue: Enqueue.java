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

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    // ENQUEUE METHOD: Adds a new node to the back of the queue
    public void enqueue(int value) {
        Node newNode = new Node(value);

        // If the queue is empty, set the new node as both first and last
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            // Otherwise, add the new node at the end and update last pointer
            last.next = newNode;
            last = newNode;
        }
        
        length++;
    }

    public static void main(String[] args) {

        Queue myQueue = new Queue(2);

        System.out.println("Before enqueue():");
        System.out.println("--------------");
        myQueue.printAll();

        myQueue.enqueue(1);

        System.out.println("\n\nAfter enqueue():");
        System.out.println("-------------");
        myQueue.printAll();

        /*
            EXPECTED OUTPUT:

            Before enqueue():
            --------------
            First: 2
            Last: 2
            Length: 1

            Queue:
            2


            After enqueue():
            -------------
            First: 2
            Last: 1
            Length: 2

            Queue:
            2
            1

        */

    }

}
