class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    if (!vis[i][j] && grid[i][j] == '1') {          // visited checking & must be land
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }

    private void bfs(int r, int c, char[][] mat, boolean[][] vis) {
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));

        int n = mat.length; // row
        int m = mat[0].length; // col

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();

            // traverse in the neighbours & mark them if its a land
            // varying from -1 to +1

            for (int rx = -1; rx <= 1; rx++) {
                for (int cx = -1; cx <= 1; cx++) {
                    if (Math.abs(rx + cx) == 1) { // 4 directional only

                    // n_row = neighbour_row ....etc
                        int n_row = row + rx;
                        int n_col = col + cx;

                        // validation

                        if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m) { // region check
                            if (mat[n_row][n_col] == '1' && !vis[n_row][n_col]) { // water & land check then visited or not checking
                                vis[n_row][n_col] = true;
                                q.add(new Pair(n_row, n_col));
                            }
                        }
                    }
                }
            }
        }
    }
}