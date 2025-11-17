import java.util.*;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int E = edges.length;
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0; i<V;i++){
            adj_list.add(new ArrayList<>());
        }
        
        for(int i=0; i<E;i++){
            adj_list.get(edges[i][0]).add(edges[i][1]);
            adj_list.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean vis[] = new boolean[V];        

        for(int i=0; i<V;i++){
            if(!vis[i]){
                // if(bfs(i, adj_list, vis))return true;
                if(dfs(i, adj_list, vis, -1)) return true;
            }
        }
        return false;
        
    }
    
    public boolean dfs(int src, List<List<Integer>> list , boolean[] vis,  int parent){
        vis[src] =true;
        for(int next : list.get(src)){
            if(!vis[next]){
                if(dfs(next, list, vis, src)) return true;
            }
            else if(next != parent) return true;
        }
        return false;
    }
    
    public boolean bfs(int src, List<List<Integer>> list , boolean[] vis){
        vis[src] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});
        while(!q.isEmpty()){
            int pair[] = q.poll();
            int node  = pair[0];
            int parent  = pair[1];
            for(int neigh : list.get(node)){
                if(!vis[neigh]){
                    vis[neigh]=true;
                    q.add(new int[]{neigh, node});
                }
                else if(parent!=neigh) return true;
                // If we meet a visited neighbor ≠ parent → cycle
            }
        }
        return false;
    }
}