package datastructures.doublylinkedlist;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);

        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        System.out.println("\nDoubly Linked List:");
        myDLL.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Head: 1
            Tail: 2
            Length: 2

            Doubly Linked List:
            1
            2
        */
    }

    static class DoublyLinkedList {

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

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        public void getHead() {
            if (head == null) {
                System.out.println("Head: null");
            } else {
                System.out.println("Head: " + head.value);
            }
        }

        public void getTail() {
            if (head == null) {
                System.out.println("Tail: null");
            } else {
                System.out.println("Tail: " + tail.value);
            }
        }

        public void getLength() {
            System.out.println("Length: " + length);
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
    }
}
