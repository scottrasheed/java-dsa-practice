public class LinkedList {

    private Node head;
    private Node tail;
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
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
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
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

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

    public Node removeLast() {
        // If the list is empty, return null
        if (length == 0) return null;

        Node temp = head;
        Node pre = head;

        // Traverse until the last node
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        // Update tail to the second last node
        tail = pre;
        tail.next = null;

        length--;

        // If the list becomes empty after removal, reset head and tail
        if (length == 0) {
            head = null;
            tail = null;
        }

        // Return the removed node
        return temp;
    }

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);

        // (2) Items - Returns 2 Node
        System.out.println(myLinkedList.removeLast().value); // Expected: 2

        // (1) Item - Returns 1 Node
        System.out.println(myLinkedList.removeLast().value); // Expected: 1

        // (0) Items - Returns null
        System.out.println(myLinkedList.removeLast()); // Expected: null
    }
}
