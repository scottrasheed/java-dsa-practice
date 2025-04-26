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

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        // Check if the queue is empty
        if (length == 0) {
            return null; // Return null if the queue is empty
        }

        // Save the current first node to return later
        Node temp = first;

        // Move the first pointer to the next node
        first = first.next;

        // If the queue becomes empty after the dequeue, set last to null
        if (first == null) {
            last = null;
        }

        // Decrease the length of the queue
        length--;

        // Return the dequeued node
        return temp;
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(2);
        myQueue.enqueue(1);

        // (2) Items - Returns 2 Node
        System.out.println(myQueue.dequeue().value);
        // (1) Item - Returns 1 Node
        System.out.println(myQueue.dequeue().value);
        // (0) Items - Returns null
        System.out.println(myQueue.dequeue());

        /*
            EXPECTED OUTPUT:
            ----------------
            2
            1
            null
        */
    }
}
