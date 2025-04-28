# Hashing & Binary Search Trees Quiz

---

### Question 1:  
**Both Insert and Lookup by key in a Hash Table is O(1):**  
- a) True  
- b) False  

<details>
<summary>Answer & Explanation</summary>

**Correct Answer:** a) True

**Explanation:**  
The average time complexity for both inserting and looking up a key in a hash table is O(1), assuming there are no hash collisions. In the best-case scenario, both operations require constant time because hash functions directly map keys to indexes in the array.

</details>

---

### Question 2:  
**Since a Hash Table is O(1) for Insert and Lookup, it is always better than a Binary Search Tree:**  
- a) True  
- b) False  

<details>
<summary>Answer & Explanation</summary>

**Correct Answer:** b) False

**Explanation:**  
Although hash tables offer O(1) time complexity for insert and lookup in the best case, they are not always better than a binary search tree (BST). For example, hash tables can perform poorly if many keys hash to the same index, leading to collisions. In contrast, a balanced binary search tree guarantees O(log n) time complexity for insert and lookup operations, which may be more predictable in some situations. Additionally, BSTs maintain ordered data, while hash tables do not.

</details>

---

### Question 3:  
**Looking up a value in a Hash Table is O(1):**  
- a) True  
- b) False  

<details>
<summary>Answer & Explanation</summary>

**Correct Answer:** b) False

**Explanation:**  
In the average case, hash table lookup is O(1), but it can degrade to O(n) in the worst case if many elements hash to the same index, causing a collision. In such cases, the time complexity can approach O(n), where n is the number of items in the hash table. Therefore, hash table lookup is not guaranteed to always be O(1).

</details>

---

