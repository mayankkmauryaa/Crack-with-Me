class Solution {
    private int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, isConnected, vis);
            }
        }
        return count;
    }

    public void dfs(int idx, int[][] mat, boolean[] vis) {
        vis[idx] = true;
        for (int i = 0; i < n; i++) {
            if (!vis[i] && mat[idx][i] == 1) {
                dfs(i, mat, vis);
            }
        }
    }
}