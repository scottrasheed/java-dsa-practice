// THIS GOES IN YOUR MAIN CLASS TO TEST YOUR CODE:
// -----------------------------------------------

package datastructures.queue;

public class Main {

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





// THIS CODE GOES IN YOUR QUEUE CLASS:
// -----------------------------------
      
package datastructures.queue;

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
        if(length == 0) return null;
        Node temp = first;
        if(length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

}

