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
        length = 1;
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
            newNode.prev = current;
        }
        length++;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex >= endIndex) return;

        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node prevStart = dummy;
        for (int i = 0; i < startIndex; i++) {
            if (prevStart.next == null) return; // Out of bounds
            prevStart = prevStart.next;
        }

        Node startNode = prevStart.next;
        Node current = startNode;
        Node next = null;

        for (int i = 0; i < endIndex - startIndex; i++) {
            next = current.next;
            if (next == null) break;

            // Detach next
            current.next = next.next;
            if (next.next != null) {
                next.next.prev = current;
            }

            // Move next to the front of the sublist
            next.prev = prevStart;
            next.next = prevStart.next;
            prevStart.next.prev = next;
            prevStart.next = next;
        }

        // Reset head if it was changed
        head = dummy.next;
        head.prev = null;
    }
}

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Test 1: Middle segment reversal");
        DoublyLinkedList dll1 = new DoublyLinkedList(3);
        dll1.append(8);
        dll1.append(5);
        dll1.append(10);
        dll1.append(2);
        dll1.append(1);
        System.out.print("BEFORE: ");
        dll1.printList();
        dll1.reverseBetween(1, 4);
        System.out.print("AFTER:  ");
        dll1.printList();

        System.out.println("\nTest 2: Full list reversal");
        DoublyLinkedList dll2 = new DoublyLinkedList(1);
        dll2.append(2);
        dll2.append(3);
        dll2.append(4);
        dll2.append(5);
        System.out.print("BEFORE: ");
        dll2.printList();
        dll2.reverseBetween(0, 4);
        System.out.print("AFTER:  ");
        dll2.printList();

        System.out.println("\nTest 3: No-op on single node");
        DoublyLinkedList dll3 = new DoublyLinkedList(9);
        System.out.print("BEFORE: ");
        dll3.printList();
        dll3.reverseBetween(0, 0);
        System.out.print("AFTER:  ");
        dll3.printList();

        System.out.println("\nTest 4: Head included in reversal");
        DoublyLinkedList dll4 = new DoublyLinkedList(7);
        dll4.append(8);
        dll4.append(9);
        System.out.print("BEFORE: ");
        dll4.printList();
        dll4.reverseBetween(0, 2);
        System.out.print("AFTER:  ");
        dll4.printList();
        
    }
    
}
