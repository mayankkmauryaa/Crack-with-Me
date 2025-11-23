# [GFG – Job Sequencing Problem](https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1)

### Difficulty: Medium | Accuracy: 34.51% | Submissions: 353K+ | Points: 4

---

## 📘 Problem Statement

You are given two arrays:

- `deadline[]`
- `profit[]`

Each index represents a **job** with a deadline and a profit.

- Each job takes **1 unit of time** to complete.
- Only **one job** can be performed at a time.
- Profit is earned **only if the job is completed on or before its deadline**.

### 🎯 Task

1. Find the **maximum number of jobs** that can be completed within their deadlines.
2. Find the **maximum total profit** earned by completing those jobs.

---

## 📝 Examples

### Example 1

```
Input: deadline = [4, 1, 1, 1]
       profit   = [20, 10, 40, 30]
Output: [2, 60]

Explanation: Jobs with profits 40 and 20 can be completed for maximum profit.
```

### Example 2

```
Input: deadline = [2, 1, 2, 1, 1]
       profit   = [100, 19, 27, 25, 15]
Output: [2, 127]

Explanation: Jobs with profits 100 and 27 can be completed for total 127 profit.
```

### Example 3

```
Input: deadline = [3, 1, 2, 2]
       profit   = [50, 10, 20, 30]
Output: [3, 100]

Explanation: Jobs with profits 50, 20, 30 can be completed.
```

---

## 🔒 Constraints

```
1 ≤ deadline.size() = profit.size() ≤ 10^5
1 ≤ deadline[i] ≤ deadline.size()
1 ≤ profit[i] ≤ 500
```

---

## 🧠 Approach

Use a **Greedy Strategy** + **Disjoint Set (DSU)**:

1. **Sort jobs by descending profit** → schedule high-profit jobs first.
2. Use DSU to track the **latest available time slot ≤ deadline**.
3. For each job:

   - Find nearest free slot via DSU.
   - If slot exists, assign job and update DSU.

4. Count total jobs and sum total profit.

**Why DSU?**

- Naive slot checking is O(n²).
- DSU allows nearly O(log n) slot allocation.

---

## 💻 Java Implementation

```java
import java.util.*;

class Job {
    int dead, profit;
    Job(int d, int p) {
        this.dead = d;
        this.profit = p;
    }
}

class Solution {

    public int find(int parent[], int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = profit.length;
        ArrayList<Job> jobs = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            jobs.add(new Job(deadline[i], profit[i]));
            max = Math.max(max, deadline[i]);
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        int parent[] = new int[max + 1];
        for (int i = 0; i <= max; i++) parent[i] = i;

        int count = 0, total = 0;
        for (Job job : jobs) {
            int slot = find(parent, job.dead);
            if (slot > 0) {
                parent[slot] = slot - 1;
                count++;
                total += job.profit;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(total);
        return ans;
    }
}
```

---

## 🧩 Time & Space Complexity

| Complexity                      | Description                 |
| ------------------------------- | --------------------------- |
| **Time Complexity:** O(n log n) | Sorting + DSU operations    |
| **Auxiliary Space:** O(n)       | DSU parent array + job list |

---

## 🏢 Company Tags

This problem was asked in:

- **Flipkart**
- **Accolite**
- **Microsoft**

---

## 🏷️ Topic Tags

- **Greedy**
- **Algorithms**
- **Disjoint Set (Union–Find)**

---

## 📚 Related Articles

- [Job Sequencing Problem Using Disjoint Set](https://www.geeksforgeeks.org/job-sequencing-problem-using-disjoint-set/)
- [Job Sequencing Problem (Greedy Approach)](https://www.geeksforgeeks.org/job-sequencing-problem/)

---

## 🎓 Related Interview Experiences

- Accolite Interview Experience – Set 15 (Campus)
- Microsoft Interview Experience – Software Engineering Internship (2019)
