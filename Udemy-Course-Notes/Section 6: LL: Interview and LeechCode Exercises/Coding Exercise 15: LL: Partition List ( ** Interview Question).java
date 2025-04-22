public class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length: " + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // Partition the list around a value x
    public void partitionList(int x) {
        Node lessHead = new Node(0);  // Dummy node for the "less than x" list
        Node greaterHead = new Node(0); // Dummy node for the "greater than or equal to x" list

        Node less = lessHead;
        Node greater = greaterHead;
        Node current = head;

        // Partition the list into two parts: less and greater
        while (current != null) {
            if (current.value < x) {
                less.next = current;
                less = less.next;
            } else {
                greater.next = current;
                greater = greater.next;
            }
            current = current.next;
        }

        // Ensure the last node points to null
        greater.next = null;

        // Connect the two lists
        less.next = greaterHead.next;

        // Set the new head
        head = lessHead.next;

        // Update the length as we may have modified the list's structure
        length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
    }

    // Main method to run the code
    public static void main(String[] args) {
        // Create a new LinkedList and append values to it
        LinkedList ll = new LinkedList(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);

        // Print the list before partitioning
        System.out.println("LL before partitionList:");
        ll.printList(); // Output: 3 5 8 10 2 1

        // Call the partitionList method with x = 5
        ll.partitionList(5);

        // Print the list after partitioning
        System.out.println("LL after partitionList:");
        ll.printList(); // Output: 3 2 1 5 8 10

        /*
            EXPECTED OUTPUT:
            ----------------
            LL before partitionList:
            3
            5
            8
            10
            2
            1
            LL after partitionList:
            3
            2
            1
            5
            8
            10
        */
    }
}
