# [GFG – Bipartite Graph](https://www.geeksforgeeks.org/problems/bipartite-graph/1)

## Difficulty: Medium | Accuracy: 31.25% | Submissions: 207K+ | Points: 4

---

## 📘 Problem Statement

You are given an **undirected graph** with:

- **V vertices** numbered from `0` to `V-1`
- **E edges**

Determine whether the graph is **bipartite**.

A bipartite graph can be colored using **two colors** such that **no two adjacent vertices have the same color**.

- All edges must connect vertices **between the two sets**
- No edges exist **within the same set**

### 🎯 Task

Return `true` if the graph is bipartite, otherwise return `false`.

---

## 📝 Examples

### Example 1

<img src="https://media.geeksforgeeks.org/wp-content/uploads/20240926114602/Bipartite-Graph.webp" width="350"/>

```md
Input: V = 3
edges = [[0,1],[1,2]]

Output: true

Explanation: Graph can be colored with two colors {0 → red, 1 → blue, 2 → red}.
```

### Example 2

<img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700410/Web/Other/blobid0_1735020917.webp" width="350"/>

```md
Input: V = 4
edges = [[0,3],[1,2],[3,2],[0,2]]
Output: false

Explanation: Graph contains an odd-length cycle (triangle), cannot be colored using 2 colors.

````

---

## 🔒 Constraints

```md
1 ≤ V ≤ 2 \* 10^5
1 ≤ edges.size() ≤ 10^5
0 ≤ edges[i][j] < V
Graph is undirected
````

---

## 🧠 Approach

1. Initialize a `color[]` array with `-1` (uncolored).

2. For each vertex `i`:

   - If uncolored, perform **BFS** starting from `i`.
   - Assign starting node color `0`.
   - For each neighbor:

     - If uncolored → assign **opposite color** and continue BFS.
     - If already colored → check for conflict. If conflict exists → **not bipartite**.

3. If BFS completes for all nodes without conflict → graph is bipartite.

**Why BFS works:**

- BFS colors nodes level by level, ensuring even cycles are handled.
- Odd cycles immediately create conflicts, making the graph non-bipartite.

---

## 💻 Java Implementation

```java
/*
    Any linear graph can be 2-colored (i.e., bipartite).

    Graph with an even cycle → can still be bipartite.
    Graph with an odd cycle  → cannot be bipartite.
*/

class Solution {

    public boolean isBipartite(int V, int[][] edges) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Check each component
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfsCheck(int start, int[] color, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbor : adj.get(node)) {

                // Assign color if uncolored
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }

                // Conflict found
                else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
```

---

## 🧩 Time & Space Complexity

| Complexity                    | Description                    |
| ----------------------------- | ------------------------------ |
| **Time Complexity:** O(V + E) | BFS + adjacency list traversal |
| **Auxiliary Space:** O(V)     | Color array + BFS queue        |

---

## 🏢 Company Tags

This problem was asked in:

- **Flipkart**
- **Microsoft**
- **Samsung**

---

## 🏷️ Topic Tags

- **Graph**
- **BFS**
- **DFS**
- **Coloring**
- **Algorithms**
- **Data Structures**

---

## 📚 Related Articles

- [Bipartite Graph (GFG)](https://www.geeksforgeeks.org/bipartite-graph/)
- [Check Graph is Bipartite Using BFS](https://www.geeksforgeeks.org/bipartite-graph/)

---

## 🎓 Related Interview Experiences

- Flipkart SDE Interview Experience (Campus)
- Samsung Research Bangalore – Software Engineer