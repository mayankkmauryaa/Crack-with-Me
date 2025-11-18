class Solution1 {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        // int dist[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                    // dist[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int idxi = pair[0];
            int idxj = pair[1];
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) == 1) {
                        int ni = idxi + i;
                        int nj = idxj + j;
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            if (!vis[ni][nj]) {
                                vis[ni][nj] = true;
                                // dist[ni][nj] = 1 + dist[idxi][idxj];
                                mat[ni][nj] = 1 + mat[idxi][idxj];
                                q.add(new int[] { ni, nj });
                            }
                        }
                    }
                }
            }
        }
        return mat; // data changes here if not wanted to change data use another matrix
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        int dist[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j ,0});
                    dist[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int idxi = pair[0];
            int idxj = pair[1];
            int steps = pair[2];
            dist[idxi][idxj] = steps;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) == 1) {
                        int ni = idxi + i;
                        int nj = idxj + j;
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            if (!vis[ni][nj]) {
                                vis[ni][nj] = true;
                                q.add(new int[] { ni, nj , steps+1});
                            }
                        }
                    }
                }
            }
        }
        return dist;
    }
}