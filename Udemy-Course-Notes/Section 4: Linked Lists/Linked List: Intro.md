# Linked List: Introduction

A **Linked List** is a linear data structure that consists of a sequence of elements, called **nodes**, where each node points to the next node in the sequence. Unlike arrays, linked lists do not store elements in contiguous memory locations, and they allow dynamic memory allocation, making them more efficient for certain operations like insertions and deletions.

## Key Concepts

### 1. Node
A node in a linked list contains two parts:
- **Data**: The value or information the node stores.
- **Next**: A reference (or pointer) to the next node in the sequence.

### 2. Head
The first node in a linked list is called the **head**. If the linked list is empty, the head is set to null.

### 3. Tail (Optional)
In some cases, a **tail** reference is maintained to optimize operations like appending nodes to the list.

### 4. Pointer
Pointers are used to reference the next node in the sequence. The last node points to null, indicating the end of the list.

## Types of Linked Lists

1. **Singly Linked List**: Each node points to the next node, and the last node points to null.
2. **Doubly Linked List**: Each node has two pointers: one pointing to the next node and another pointing to the previous node.
3. **Circular Linked List**: The last node points back to the head, forming a loop.

## Operations on Linked Lists

- **Insertion**: Add a node at the beginning, end, or at a specific position.
- **Deletion**: Remove a node from the beginning, end, or a specific position.
- **Traversal**: Access each node starting from the head.
- **Search**: Find a node containing a specific value.

## Advantages of Linked Lists
- **Dynamic Size**: The size of a linked list can grow or shrink dynamically, unlike arrays that have a fixed size.
- **Efficient Insertion/Deletion**: Inserting or deleting nodes in a linked list, especially at the beginning, is faster than in arrays.

## Disadvantages of Linked Lists
- **Memory Overhead**: Each node requires extra memory for the pointer/reference to the next node.
- **Sequential Access**: To access a specific node, traversal from the head is required, which takes O(n) time.

## Conclusion
Linked lists are a flexible and efficient way of managing data when dynamic memory allocation is needed. While they come with some overhead, they are a valuable tool for many problems, especially when frequent insertions and deletions are required.
