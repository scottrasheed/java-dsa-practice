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

    public int getLength() {
        return length;
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
        if (length == 0) {
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

    public void swapPairs() {
        if (head == null || head.next == null) {
            return; // Nothing to swap if the list is empty or has just one element.
        }

        Node current = head;

        // Traverse the list and swap each pair of nodes
        while (current != null && current.next != null) {
            Node firstNode = current;
            Node secondNode = current.next;

            // Swap the pair of nodes
            firstNode.next = secondNode.next;
            if (secondNode.next != null) {
                secondNode.next.prev = firstNode;
            }

            secondNode.prev = firstNode.prev;
            if (firstNode.prev != null) {
                firstNode.prev.next = secondNode;
            } else {
                head = secondNode; // Update the head if swapping the first two nodes
            }

            secondNode.next = firstNode;
            firstNode.prev = secondNode;

            // Move to the next pair
            current = firstNode.next;
        }
    }

    public static void main(String[] args) {
        
        DoublyLinkedList myDll = new DoublyLinkedList(1);
        myDll.append(2);
        myDll.append(3);
        myDll.append(4);

        System.out.println("myDll before swapPairs:");
        myDll.printList();

        myDll.swapPairs();

        System.out.println("\nmyDll after swapPairs:");
        myDll.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            myDll before swapPairs:
            1 <-> 2 <-> 3 <-> 4
            
            myDll after swapPairs:
            2 <-> 1 <-> 4 <-> 3

        */
    }
}
