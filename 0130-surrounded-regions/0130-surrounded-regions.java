class Solution {
    // start from the boundaries 0's & mark them that they would not be converted && converted other 0's to X

    // from boundary -> find O's & traverse & mark all O's connected to it
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O' && !vis[i][j]) {
                        dfs(board, i, j, vis);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c, boolean[][] vis) {
        int m = board.length;
        int n = board[0].length;
        vis[r][c] = true;
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <=1; j++) {
                if (Math.abs(i + j) == 1) {
                    int nr = r + i;
                    int nc = c + j;

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        if (!vis[nr][nc] && board[nr][nc] == 'O') {
                            dfs(board, nr, nc, vis);
                        }
                    }
                }
            }
        }
    }
}