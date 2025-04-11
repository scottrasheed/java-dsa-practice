public class LinkedList {
  Node head;
  Node tail;
  int length;

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public void printList() {
    Node current = head;
    while (current != null) {
      System.out.print(current.value + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }
}

class Node {
  int value;
  Node next;

  public Node(int value) {
    this.value = value;
    this.next = null;
  }
}
