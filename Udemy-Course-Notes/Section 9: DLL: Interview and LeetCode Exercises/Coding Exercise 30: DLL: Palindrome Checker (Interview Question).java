public class DoublyLinkedList {

    private Node head;
    private Node tail;
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
        System.out.println("\nDoubly Linked List:");
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
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public boolean isPalindrome() {
        if (length <= 1) return true;

        Node left = head;
        Node right = tail;

        while (left != right && left.prev != right) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }

        return true;
    }

    // Main method INSIDE DoublyLinkedList class
    public static void main(String[] args) {

        DoublyLinkedList myDLL1 = new DoublyLinkedList(1);
        myDLL1.append(2);
        myDLL1.append(3);
        myDLL1.append(2);
        myDLL1.append(1);

        System.out.println("myDLL1 isPalindrome:");
        System.out.println(myDLL1.isPalindrome()); // true

        DoublyLinkedList myDLL2 = new DoublyLinkedList(1);
        myDLL2.append(2);
        myDLL2.append(3);

        System.out.println("\nmyDLL2 isPalindrome:");
        System.out.println(myDLL2.isPalindrome()); // false

        /*
            EXPECTED OUTPUT:
            ----------------
            myDLL1 isPalindrome:
            true

            myDLL2 isPalindrome:
            false
        */
    }
}
