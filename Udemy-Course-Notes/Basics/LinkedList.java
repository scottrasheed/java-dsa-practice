public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    // Constructor to initialize the LinkedList with a value
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Method to append a value to the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Method to print the list values
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the LinkedList functionality
    public static void main(String[] args) {
        LinkedList list = new LinkedList(10);  // Initialize with 10
        list.append(20);  // Append 20
        list.append(30);  // Append 30
        list.printList();  // Output: 10 20 30
    }

    // Node class to represent each element
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}

/*
  Sticky Note:

  1. The LinkedList is initialized with a single value (10 in this case) using the constructor.
  2. The `append` method adds new values to the end of the list.
  3. The `printList` method prints the values of the linked list.
  4. The main method demonstrates creating a linked list, appending values, and printing the result.
  5. The Node class defines each element in the linked list, holding a value and a reference to the next node.

*/
