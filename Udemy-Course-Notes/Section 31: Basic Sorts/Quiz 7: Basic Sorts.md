# Quiz 7: Basic Sorts

Test your understanding of Bubble Sort, Selection Sort, and Insertion Sort.

---

### **Question 1:**
**Bubble, Selection, and Insertion Sort all have O(n) time complexity.**

❌ **False**  
Each of these three sorting algorithms uses a loop inside a loop (nested loops), resulting in **O(n²)** time complexity in the average and worst cases.

---

### **Question 2:**
**Bubble, Selection, and Insertion Sort have O(1) space complexity.**

✅ **True**  
All three sort the array in place, meaning they **do not create additional copies** of the array or use extra space proportional to the input. Thus, their space complexity is **O(1)**.

---

### **Question 3:**
**Bubble, Selection, and Insertion Sort are all O(n) if you start with a sorted (or almost sorted) array.**

❌ **False**  
Only **Insertion Sort** has a best-case time complexity of **O(n)** when the data is already sorted or nearly sorted.  
Bubble Sort (even optimized) and Selection Sort still take **O(n²)** in most cases.

---
