class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for(int n: nums){
            ans = Math.max(ans,n);
        }
        int currMax = 1;
        int currMin = 1;
        for(int a: nums){
            int currVal = a*currMax;
            currMax = Math.max(currVal, Math.max(currMin*a, a));
            currMin = Math.min(currVal, Math.min(currMin*a, a));

            ans = Math.max(ans,currMax);
        }
        return ans;
    }
}
