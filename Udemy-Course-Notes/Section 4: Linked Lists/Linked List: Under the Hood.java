public class Main {

    // Node class to represent each element of the linked list
    static class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
    public static void main(String[] args) {
        // Build the linked list to match the given structure:
        // head -> 11 -> 3 -> 23 -> 7 -> 4 -> null (tail)
        Node head = new Node(11);
        head.next = new Node(3);
        head.next.next = new Node(23);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(4);
        
        // Print the linked list
        printList(head);
    }
    
    // Utility method to print the linked list in a nice format
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }
}
