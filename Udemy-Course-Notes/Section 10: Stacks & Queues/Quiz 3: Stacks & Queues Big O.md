# Stack and Queue Basics - 3 Question Quiz

---

### Question 1:
**Pushing an item onto a Stack is O(1).**

- A) True
- B) False

---

### Question 2:
**Removing an item from a Queue is O(1).**

- A) True
- B) False

---

### Question 3:
**It is common to implement a Stack using an ArrayList.**

- A) True
- B) False

---

# 📖 Answer Key
<details>
<summary>Click to reveal answers and explanations</summary>

---

### Question 1:
**Answer:** A) True

**Explanation:**  
Pushing onto a stack only involves creating a new node and updating a pointer.  
There’s no searching or traversing involved, making it a **constant-time (O(1))** operation.

---

### Question 2:
**Answer:** A) True

**Explanation:**  
In a properly designed queue (with a head pointer), removing the front item is a **simple pointer update**.  
No need to loop through the queue — it’s a **constant-time (O(1))** operation.

---

### Question 3:
**Answer:** A) True

**Explanation:**  
It’s common to implement a stack with an ArrayList because adding/removing from the end of an ArrayList is **fast (O(1))** on average.  
The last element naturally acts as the **top of the stack**, making ArrayList a convenient choice.

---
</details>
