public class LinkedList {
    private Node head;

    // Node class to represent elements in the list
    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Constructor for LinkedList (initializes with one node)
    public LinkedList(int value) {
        this.head = new Node(value);
    }

    // Method to append a new node at the end of the list
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to remove the last node from the list
    public Node removeLast() {
        if (head == null) {
            return null; // List is empty
        }

        if (head.next == null) {
            Node removedNode = head;
            head = null;
            return removedNode;
        }

        Node current = head;
        while (current.next != null && current.next.next != null) {
            current = current.next;
        }

        Node removedNode = current.next;
        current.next = null;
        return removedNode;
    }

    // Method to prepend a node at the beginning of the list
    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a node at a specific index
    public boolean insert(int index, int value) {
        if (index < 0) {
            return false;
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return true;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                return false; // Index out of bounds
            }
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        return true;
    }

    // Method to remove a node at a specific index
    public Node remove(int index) {
        if (head == null || index < 0) {
            return null; // List is empty or invalid index
        }

        if (index == 0) {
            Node removedNode = head;
            head = head.next;
            return removedNode;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) {
                return null; // Index out of bounds
            }
            current = current.next;
        }

        Node removedNode = current.next;
        current.next = current.next.next;
        return removedNode;
    }

    // Method to print the list (for testing)
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(10);
        list.append(20);
        list.append(30);
        list.prepend(5);
        list.printList(); // Output: 5 -> 10 -> 20 -> 30 -> null

        list.insert(2, 25);
        list.printList(); // Output: 5 -> 10 -> 25 -> 20 -> 30 -> null

        list.remove(3);
        list.printList(); // Output: 5 -> 10 -> 25 -> 30 -> null

        list.removeLast();
        list.printList(); // Output: 5 -> 10 -> 25 -> null
    }
}
