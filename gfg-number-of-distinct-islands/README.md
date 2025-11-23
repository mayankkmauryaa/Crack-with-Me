# [GFG - Number of Distinct Islands](https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1)

## Difficulty: Medium | Accuracy: 62.29% | Submissions: 122K+ | Points: 4

---

## 📘 Problem Statement

You are given a boolean 2D matrix **grid** of size **n × m**, where:

- `1` represents **land**
- `0` represents **water**

An **island** is a group of connected `1`s (connected **horizontally** or **vertically**).

Two islands are considered **distinct** only if their **shapes are different**. Islands that are **rotated** or **reflected** are **not** considered equal.

Your task is to **count the number of distinct islands**.

---

## 🔍 Examples

### Example 1

```java
Input:
grid = [[1, 1, 0, 0, 0],
        [1, 1, 0, 0, 0],
        [0, 0, 0, 1, 1],
        [0, 0, 0, 1, 1]]

Output: 1

Explanation: Two islands exist but they have the same shape.
```

### Example 2

```java
Input:
grid = [[1, 1, 0, 1, 1],
        [1, 0, 0, 0, 0],
        [0, 0, 0, 0, 1],
        [1, 1, 0, 1, 1]]

Output: 3

Explanation: Four islands exist, but two share the same shape → 3 distinct islands.
```

---

## 🧠 Approach

1. Traverse the grid.
2. When a land cell `1` is found, start a **BFS/DFS**.
3. Record each visited land cell's **relative coordinates** `(row - baseRow, col - baseCol)` to normalize the shape.
4. This creates a **unique signature** for the island.
5. Store the signature in a **Set** to ensure uniqueness.
6. The number of unique signatures = **distinct islands**.

---

## 💻 Java Implementation

```java
class Solution {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<String> set = new HashSet<>();
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {

                    List<String> shape = new ArrayList<>();
                    bfs(i, j, grid, vis, shape, i, j);
                    set.add(String.join(",", shape));
                }
            }
        }
        return set.size();
    }

    private void bfs(int r, int c, int[][] mat, boolean[][] vis,
                     List<String> shape, int baseR, int baseC) {

        vis[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        int n = mat.length;
        int m = mat[0].length;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int row = arr[0];
            int col = arr[1];

            shape.add((row - baseR) + ":" + (col - baseC));

            int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
            for (int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    mat[nr][nc] == 1 && !vis[nr][nc]) {

                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
```

---

## 📘 Constraints

- `1 ≤ n, m ≤ 500`
- `grid[i][j]` is either `0` or `1`

---

## 🧩 Time & Space Complexity

| Metric              | Value                   |
| ------------------- | ----------------------- |
| **Time Complexity** | `O(n * m * log(n * m))` |
| **Auxiliary Space** | `O(n * m)`              |

---

## 🏷️ Topic Tags

- BFS
- DFS
- Graph
- Data Structures
- Algorithms

---

## 📎 Related Article

Find The Number Of Distinct Islands In A 2D Matrix
