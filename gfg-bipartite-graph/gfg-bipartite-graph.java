/*
    Any linear graph can be 2-colored (i.e., bipartite).

    Graph with an even cycle → can still be bipartite.
    Graph with an odd cycle  → cannot be bipartite.
*/
import java.util.*;


class Solution {

    public boolean isBipartite(int V, int[][] edges) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Check each component
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfsCheck(int start, int[] color, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbor : adj.get(node)) {

                // Assign color if uncolored
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.add(neighbor);
                }

                // Conflict found
                else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
