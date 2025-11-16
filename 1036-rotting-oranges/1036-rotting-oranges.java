class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;

        // int time = -1; // one has already rotten up   // case 1
        int time = 0; // case 2
        while (!q.isEmpty()) {
            int size = (q.size());
            boolean rottenNOW = false; // case 2
            // time++;  // case 1

            for (int s = 0; s < size; s++) {
                int[] next = q.poll();
                int row = next[0];
                int col = next[1];

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (Math.abs(i + j) == 1) {
                            int nr = row + i;
                            int nc = col + j;
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                if (grid[nr][nc] == 1) {
                                    grid[nr][nc] = 2;
                                    fresh--;
                                    q.add(new int[] { nr, nc });
                                    rottenNOW = true; // case 2
                                }
                            }
                        }
                    }
                }
            }
            if (rottenNOW) time++; // case 2
        }
        return fresh == 0 ? time : -1;
    }
}