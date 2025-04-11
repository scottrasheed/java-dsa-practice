public LinkedList(int value) {
  Node newNode = new Node(value);
  head = newNode;
  tail = newNode;
  length = 1;
}


public void append(int value) {
  Node newNode = new Node (value);
  if (head == null) {
    head = newNode;
    tail = newNode;
    }else{
      tail.next = newNode;
      tail = newNode;
    }
    length++;
}
