public class LinkedList {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    // Empty constructor
    public LinkedList() {
        head = null;
        tail = null;
    }

    // Constructor with initial value
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        LinkedList myLinkedList = new LinkedList();  // Use empty constructor
        System.out.println("Expected: null");
        System.out.println("Actual: " + (myLinkedList.findMiddleNode() == null ? "null" : myLinkedList.findMiddleNode().value));
        System.out.println();

        // Test 2: List with 1 element
        System.out.println("Test 2: List with 1 Element");
        myLinkedList = new LinkedList(1);
        System.out.println("1");
        System.out.println("Expected Middle Node: 1");
        System.out.println("Actual Middle Node: " + (myLinkedList.findMiddleNode() == null ? "null" : myLinkedList.findMiddleNode().value));
        System.out.println();

        // Test 3: List with odd number of elements
        System.out.println("Test 3: List with Odd Number of Elements");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        System.out.println("1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected Middle Node: 3");
        System.out.println("Actual Middle Node: " + (myLinkedList.findMiddleNode() == null ? "null" : myLinkedList.findMiddleNode().value));
        System.out.println();

        // Test 4: List with even number of elements
        myLinkedList.append(6);
        System.out.println("Test 4: List with Even Number of Elements");
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println("Expected Middle Node: 4");
        System.out.println("Actual Middle Node: " + (myLinkedList.findMiddleNode() == null ? "null" : myLinkedList.findMiddleNode().value));
        System.out.println();
    }
}
