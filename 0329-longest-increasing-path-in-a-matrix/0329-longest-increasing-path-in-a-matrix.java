class Solution {
    private int m, n;
    private int[][] dp;

    // TC : O(m*n)
    // DFS explores all increasing paths from a cell.
    // DP stores the longest path starting from that cell, so we never recompute it.
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        if (matrix == null || m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // max = Math.max(max, bfs(matrix, i, j));
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] mat, int r, int c) {
        if (dp[r][c] != 0)
            return dp[r][c]; // we already computed the answer for this cell, return it immediately.

        int max = 1; // Minimum path length = 1 (the cell itself).

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (Math.abs(i + j) == 1) {
                    int nr = r + i;
                    int nc = c + j;
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    if (mat[nr][nc] > mat[r][c]) {
                        max = Math.max(max, 1 + dfs(mat, nr, nc));
                    }
                }
            }
        }

        dp[r][c] = max;
        return max;
    }
}

// TLE : O(m * n * (m * n)) = O((150*10)^2) ~= O(2.25 million^2) ~ 5e12 operations

//     private int bfs(int[][] mat, int row, int col) {
//         int max = 0;
//         int m = mat.length;
//         int n = mat[0].length;

//         Queue<int[]> q = new LinkedList<>();
//         q.add(new int[] { row, col });

//         while (!q.isEmpty()) {
//             int size = q.size();

//             max++;
//             for (int s = 0; s < size; s++) {
//                 int curr[] = q.poll();

//                 for (int r = -1; r <= 1; r++) {
//                     for (int c = -1; c <= 1; c++) {
//                         if (Math.abs(r + c) == 1) {

//                             int nr = curr[0] + r;
//                             int nc = curr[1] + c;

//                             if (nr < 0 || nr >= m || nc < 0 || nc >= n)
//                                 continue;
//                             if (mat[nr][nc] <= mat[curr[0]][curr[1]])
//                                 continue;

//                             q.add(new int[] { nr, nc });
//                         }
//                     }
//                 }
//             }
//         }
//         return max;
//     }