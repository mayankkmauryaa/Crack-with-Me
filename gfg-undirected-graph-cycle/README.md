# [GFG – Undirected Graph Cycle](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)

## Difficulty: Medium | Accuracy: 30.13% | Submissions: 662K+ | Points: 4

---

## 📘 Problem Statement

Given an **undirected graph** with `V` vertices and `E` edges, represented by a 2D list `edges[][]` where each element `[u, v]` denotes an edge between vertices `u` and `v`, determine whether the graph contains a **cycle**.

> **Note:** The graph may consist of multiple disconnected components.

### 🎯 Task

Return `true` if the graph contains **at least one cycle**, otherwise return `false`.

---

## 📝 Examples

### Example 1

![Graph with a cycle](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/891735/Web/Other/blobid1_1743510240.jpg)

```
Input: V = 4, E = 4
edges = [[0, 1], [0, 2], [1, 2], [2, 3]]

Output: true

Explanation: 1 → 2 → 0 → 1 forms a cycle.
```

### Example 2

![Graph without a cycle](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/891735/Web/Other/blobid2_1743510254.jpg)

```
Input: V = 4, E = 3
edges = [[0, 1], [1, 2], [2, 3]]

Output: false

Explanation: No cycle exists in the graph.
```

---

## 🔒 Constraints

```
1 ≤ V, E ≤ 10^5
0 ≤ edges[i][0], edges[i][1] < V
```

---

## 🧠 Approach

### 1️⃣ Using DFS

- Traverse all graph components.
- For each node, keep track of **visited nodes**.
- If a visited neighbor is encountered that is **not the parent**, a cycle exists.

### 2️⃣ Using BFS

- Use a queue storing `[node, parent]`.
- Mark nodes visited.
- If a visited neighbor ≠ parent is found → cycle.

**Why this works:**

- In an undirected graph, encountering an already visited neighbor that is not the parent indicates a back edge → cycle.

---

## 💻 Java Implementation

```java
import java.util.*;

class Solution {

    public boolean isCycle(int V, int[][] edges) {
        int E = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adjList, vis, -1)) return true;
                // Alternatively, use BFS:
                // if (bfs(i, adjList, vis)) return true;
            }
        }
        return false;
    }

    // DFS helper
    public boolean dfs(int src, List<List<Integer>> adj, boolean[] vis, int parent) {
        vis[src] = true;
        for (int next : adj.get(src)) {
            if (!vis[next]) {
                if (dfs(next, adj, vis, src)) return true;
            } else if (next != parent) return true;
        }
        return false;
    }

    // BFS helper
    public boolean bfs(int src, List<List<Integer>> adj, boolean[] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});
        vis[src] = true;

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];
            for (int neigh : adj.get(node)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(new int[]{neigh, node});
                } else if (neigh != parent) return true;
            }
        }
        return false;
    }
}
```

---

## 🧩 Time & Space Complexity

| Complexity          | Value                                                             |
| ------------------- | ----------------------------------------------------------------- |
| **Time**            | O(V + E) — traverse all vertices and edges                        |
| **Auxiliary Space** | O(V + E) — adjacency list + visited array + queue/recursion stack |

---

## 🏢 Company Tags

- Flipkart
- Amazon
- Microsoft
- Samsung
- MakeMyTrip
- Oracle
- Adobe

---

## 🏷️ Topic Tags

- DFS
- BFS
- Graph
- Union-Find
- Data Structures
- Algorithms

---

## 📚 Related Articles

- [Detect Cycle in an Undirected Graph using BFS](https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-bfs/)
- [Detect Cycle in an Undirected Graph](https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph/)

---

## 🎓 Related Interview Experiences

- MakeMyTrip Interview Experience – Set 13 On Campus (Full Time)
