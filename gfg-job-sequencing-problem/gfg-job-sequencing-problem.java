import java.util.*;

class Job{
    int dead, profit;
    Job(int d, int p){
        this.dead = d;
        this.profit = p;
    }
}

class Solution {
    
    public int find(int parent[], int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent, parent[x]);
    }
    
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = profit.length;
        ArrayList<Job> jobs = new ArrayList<>();
        int max = 0;
        
        for(int i=0; i<n ; i++){
            jobs.add(new Job(deadline[i], profit[i]));
            max = Math.max(max, deadline[i]);
        }
        
        Collections.sort(jobs, (a,b) -> b.profit - a.profit);
        
        int parent[] = new int[max+1];
        for(int i=0 ;i<=max; i++){
            parent[i] = i;
        }
        int slot[] = new int[max+1];
        // Arrays.fill(slot, -1);
        int total = 0;
        int count = 0;
        for(Job job : jobs){
            // for(int i=job.dead; i>0; i--){
            //     if(slot[i]==0){
            //         slot[i]=job.profit;
            //         total+=job.profit;
            //         count++;
            //         break;
            //     }
            // }
            int isfound = find(parent, job.dead);
            if(isfound>0){
                parent[isfound] = isfound-1;
                count++;
                total+=job.profit;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(total);
        return ans;
    }
}