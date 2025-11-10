class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] visitedDFS = new boolean[size];
        int count = 0;
        int start_idx = 0;
        for (int i = start_idx; i < size; i++) {
            if (!visitedDFS[i]) {
                List<Integer> dfslist = new ArrayList<>();
                dfs_graph(i, isConnected, visitedDFS, dfslist);
                
                System.out.println("DFS traversal from node " + i + ": " + dfslist);
                count++;
            }
        }
        
        System.out.println("Number of connected components: " + count);
        return count;
    }

    private static void dfs_graph(int node, int [][] isConnected, boolean[] visited, List<Integer> dfs) {
        dfs.add(node);
        visited[node] = true;
        for (int i=0;i<isConnected.length; i++) {
            if (isConnected[node][i]==1 && !visited[i]) {
                dfs_graph(i, isConnected, visited, dfs);
            }
        }
    }
}