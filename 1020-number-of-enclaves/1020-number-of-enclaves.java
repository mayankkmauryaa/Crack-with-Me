class Solution {
    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 1 && !vis[i][j]) {
                        q.add(new int[] { i, j });
                        vis[i][j] = true;
                        // dfs(board, i, j, vis);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) == 1) {
                        int nr = r + i;
                        int nc = c + j;

                        if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                            if (!vis[nr][nc] && board[nr][nc] == 1) {
                                q.add(new int[] { nr, nc });
                                vis[nr][nc] = true;
                                // dfs(board, nr, nc, vis);
                            }
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == 1) {
                    board[i][j] = 0;
                    count++;
                }
            }
        }
        return count;
    }
}
