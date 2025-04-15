package datastructures.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList list = new LinkedList(5);
        System.out.println("LinkedList created with head value: " + list.head.value);
    }
}
