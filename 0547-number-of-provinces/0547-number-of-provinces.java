class Solution {
    int n;
    boolean vis[];

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, isConnected);
                count++;
            }
        }
        return count;
    }

    public void dfs(int st, int arr[][]) {
        vis[st] = true;
        for (int i = 0; i < n; i++) {
            if (!vis[i] && arr[st][i] == 1) {
                dfs(i, arr);
            }
        }
    }
}