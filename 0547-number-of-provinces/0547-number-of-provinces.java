class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
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

    private void dfs(int idx, int[][] mat, boolean[] vis) {
        vis[idx] = true;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            if (!vis[i] && mat[idx][i] == 1) {
                dfs(i, mat, vis);
            }
        }
    }
}