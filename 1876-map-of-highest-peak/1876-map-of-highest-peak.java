class Solution1 {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        boolean[][] vis = new boolean[n][m];
        int[][] height = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    vis[i][j] = true;
                    height[i][j] = 0;
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int idxi = arr[0];
            int idxj = arr[1];
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i + j) == 1) {
                        int ni = idxi + i;
                        int nj = idxj + j;
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            if (!vis[ni][nj]) {
                                vis[ni][nj] = true;
                                height[ni][nj] = 1 + height[idxi][idxj];
                                q.add(new int[] { ni, nj });
                            }
                        }
                    }
                }
            }
        }
        return height;
    }
}


class Solution {
    public int[][] highestPeak(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        int dist[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    q.add(new int[] { i, j ,0});
                    dist[i][j] = 1;
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