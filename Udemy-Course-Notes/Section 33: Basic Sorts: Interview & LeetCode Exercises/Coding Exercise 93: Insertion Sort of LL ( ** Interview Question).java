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

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
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
    
public void insertionSort() {
    if (head == null || head.next == null) return;

    Node sortedHead = null;

    Node current = head;
    while (current != null) {
        Node nextNode = current.next;

        if (sortedHead == null || current.value < sortedHead.value) {
            // Insert at beginning
            current.next = sortedHead;
            sortedHead = current;
        } else {
            // Traverse sorted part and insert
            Node temp = sortedHead;
            while (temp.next != null && temp.next.value < current.value) {
                temp = temp.next;
            }
            current.next = temp.next;
            temp.next = current;
        }

        current = nextNode;
    }

    // Update head, tail, and ensure tail.next is null
    head = sortedHead;
    tail = head;
    while (tail.next != null) {
        tail = tail.next;
    }
    tail.next = null;
}


}

public class Main {

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);


        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

        myLinkedList.insertionSort();

        System.out.println("\nSorted Linked List:");
        myLinkedList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Unsorted Linked List:
            4
            2
            6
            5
            1
            3
            
            Sorted Linked List:
            1
            2
            3
            4
            5
            6

        */

    }

}
