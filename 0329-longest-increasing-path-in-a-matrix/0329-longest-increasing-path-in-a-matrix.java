class Solution {
    private int m, n;
    private int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        if (matrix == null || m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        int max = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                max = Math.max(max, dfs(matrix, i, j));
        return max;
    }

    private int dfs(int[][] mat, int r, int c) {
        if (dp[r][c] != 0)
            return dp[r][c];
        int max = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (Math.abs(i + j) == 1) {
                    int nr = r + i;
                    int nc = c + j;
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;
                    if (mat[nr][nc] > mat[r][c])
                        max = Math.max(max, 1 + dfs(mat, nr, nc));
                }
            }
        }
        dp[r][c] = max;
        return max;
    }
}