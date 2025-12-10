class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if (fresh == 0)
            return 0;

        int time = 0;
        while (!q.isEmpty()) {
            int size = (q.size());
            boolean rottenNOW = false;

            for (int s = 0; s < size; s++) {
                int[] next = q.poll();
                int row = next[0];
                int col = next[1];

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (Math.abs(i + j) == 1) {
                            int nr = row + i;
                            int nc = col + j;
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                                if (grid[nr][nc] == 1) {
                                    grid[nr][nc] = 2;
                                    fresh--;
                                    q.add(new int[] { nr, nc });
                                    rottenNOW = true;
                                }
                            }
                        }
                    }
                }
            }
            if (rottenNOW)
                time++;
        }
        return fresh == 0 ? time : -1;
    }
}