## Linked List - Multiple Choice Questions with Answers and Explanations

---

### 1. Removing the **last item** from a Linked List is:

A. O(1)  
B. O(log n)  
C. O(n²)  
D. O(n) ✅

**Explanation:**  
You have to start at the beginning of the Linked List and iterate through to the end to find the second-to-last node and remove the last node. This takes linear time.

---

### 2. Removing the **first item** from a Linked List is:

A. O(1) ✅  
B. O(log n)  
C. O(n²)  
D. O(n)

**Explanation:**  
This is a place where Linked Lists are better than ArrayLists. Removing the first node just requires updating the head pointer, which is constant time.  
In contrast, ArrayLists take O(n) time to remove the first item due to the reindexing (shifting) of all elements.

---

### 3. Finding an item **by index** in a Linked List is:

A. O(1)  
B. O(log n)  
C. O(n²)  
D. O(n) ✅

**Explanation:**  
You must iterate through the Linked List starting from the head until you reach the desired index. There is no direct access like in arrays, so it takes linear time.

