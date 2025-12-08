class Solution {
    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int k_sq = i * i + j * j;
                int k = (int)Math.sqrt(k_sq);
                if(k*k==k_sq && k<=n){
                    count++;
                }
            }
        }
        return count ;
    }
}