class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int n = nums.length;
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }

    public int maxSubArray1(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxsum = Math.max(maxsum, sum);
            if (sum < 0) sum = 0;
        }
        return maxsum;
    }
}