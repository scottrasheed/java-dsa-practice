# Quiz 6: Graph Big O

---

### Question 1
**Adding a Vertex in a Graph with an Adjacency List is O(1):**

<details>
<summary><em>Click to reveal the answer</em></summary>

✅ **True**

**Explanation:**  
Adding a new vertex only involves inserting a key into a HashMap with an empty ArrayList.  
Both operations are **constant time**, so the overall time complexity is **O(1)**.

</details>

---

### Question 2
**Graphs are the go-to data structure when you need to represent entities and the relationships between them:**

<details>
<summary><em>Click to reveal the answer</em></summary>

✅ **True**

**Explanation:**  
Graphs are perfect for modeling **connections** between objects (like cities, friends, computers, etc.).  
They naturally represent **entities** (as vertices) and **relationships** (as edges).

</details>

---

### Question 3
**Removing a vertex is O(1):**

<details>
<summary><em>Click to reveal the answer</em></summary>

❌ **False**

**Explanation:**  
Removing a vertex requires **deleting all edges** connected to it,  
which takes **O(V + E)** time in the worst case, not constant **O(1)**.

</details>

---
