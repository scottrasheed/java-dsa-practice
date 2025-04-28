🧠 Binary Search Trees (BST) Quiz
Test your understanding of Binary Search Trees!
(Click to reveal the answers after attempting each question.)

Question 1
True or False:
Binary Search Trees always have a better Big O than Linked Lists.

<details> <summary>Click to show answer</summary>
Answer: False

Explanation:
A Binary Search Tree (BST) only has O(log n) performance if it remains balanced.
If it becomes unbalanced, operations can degrade to O(n), similar to a Linked List.
Therefore, BSTs do not always have a better Big O than Linked Lists.

</details>
Question 2
True or False:
Binary Search Trees use divide and conquer.

<details> <summary>Click to show answer</summary>
Answer: True

Explanation:
A BST uses divide and conquer by narrowing the search at each node.
At every step, you either go left or right depending on the value, effectively dividing the problem space in half.

</details>
Question 3
True or False:
Adding an item to a Binary Search Tree is always O(log n).

<details> <summary>Click to show answer</summary>
Answer: False

Explanation:
Insertion into a BST is O(log n) only if the tree is balanced.
If the tree becomes unbalanced (e.g., inserting sorted data into an empty BST), insertion can take O(n) time in the worst case.

</details>
Bonus Question
Multiple Choice:
Which data structure guarantees that a Binary Search Tree stays balanced?

A) Stack
B) Queue
C) AVL Tree
D) Hash Table

<details> <summary>Click to show answer</summary>
Answer: C) AVL Tree

Explanation:
An AVL Tree is a type of self-balancing Binary Search Tree that ensures O(log n) time complexity for search, insert, and delete operations.

</details>
