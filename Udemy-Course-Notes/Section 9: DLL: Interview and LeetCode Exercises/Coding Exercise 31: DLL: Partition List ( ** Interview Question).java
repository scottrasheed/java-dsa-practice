public class DoublyLinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
    }

    public void printList() {
        StringBuilder output = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            output.append(temp.value);
            if (temp.next != null) {
                output.append(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(output.toString());
    }

    public void makeEmpty() {
        head = null;
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
            newNode.prev = current;
        }
    }

    
    public void partitionList(int x) {
        if (head == null || head.next == null) return;

        Node lessDummy = new Node(0);
        Node greaterDummy = new Node(0);
        Node lessTail = lessDummy;
        Node greaterTail = greaterDummy;

        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.prev = null;
            current.next = null;

            if (current.value < x) {
                lessTail.next = current;
                current.prev = lessTail;
                lessTail = current;
            } else {
                greaterTail.next = current;
                current.prev = greaterTail;
                greaterTail = current;
            }

            current = nextNode;
        }

        // Join two partitions
        if (lessDummy.next != null) {
            head = lessDummy.next;
            lessTail.next = greaterDummy.next;
            if (greaterDummy.next != null) {
                greaterDummy.next.prev = lessTail;
            }
        } else {
            head = greaterDummy.next;
        }

        if (head != null) head.prev = null;
    }
}

public class Main {

    public static void main(String[] args) {
        
        System.out.println("=== Partition List (Doubly Linked List) ===\n");

        System.out.println("Test Case 1: Mixed values around 5");
        DoublyLinkedList dll1 = new DoublyLinkedList(3);
        dll1.append(8);
        dll1.append(5);
        dll1.append(10);
        dll1.append(2);
        dll1.append(1);
        System.out.print("BEFORE: ");
        dll1.printList();  // Expected: 3 <-> 8 <-> 5 <-> 10 <-> 2 <-> 1
        dll1.partitionList(5);
        System.out.print("AFTER:  ");
        dll1.printList();  // Expected: 3 <-> 2 <-> 1 <-> 8 <-> 5 <-> 10

        System.out.println("\nTest Case 2: All nodes less than 5");
        DoublyLinkedList dll2 = new DoublyLinkedList(1);
        dll2.append(2);
        dll2.append(3);
        System.out.print("BEFORE: ");
        dll2.printList();  // Expected: 1 <-> 2 <-> 3
        dll2.partitionList(5);
        System.out.print("AFTER:  ");
        dll2.printList();  // Expected: 1 <-> 2 <-> 3

        System.out.println("\nTest Case 3: All nodes greater than 5");
        DoublyLinkedList dll3 = new DoublyLinkedList(6);
        dll3.append(7);
        dll3.append(8);
        System.out.print("BEFORE: ");
        dll3.printList();  // Expected: 6 <-> 7 <-> 8
        dll3.partitionList(5);
        System.out.print("AFTER:  ");
        dll3.printList();  // Expected: 6 <-> 7 <-> 8

        System.out.println("\nTest Case 4: Empty list");
        DoublyLinkedList dll4 = new DoublyLinkedList(1);
        dll4.makeEmpty();
        System.out.print("BEFORE: ");
        dll4.printList();  // Expected: (empty)
        dll4.partitionList(5);
        System.out.print("AFTER:  ");
        dll4.printList();  // Expected: (empty)

        System.out.println("\nTest Case 5: Single node");
        DoublyLinkedList dll5 = new DoublyLinkedList(1);
        System.out.print("BEFORE: ");
        dll5.printList();  // Expected: 1
        dll5.partitionList(5);
        System.out.print("AFTER:  ");
        dll5.printList();  // Expected: 1

        System.out.println("\n===========================================\n");
    }

}


