class Solution {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int totalSum = 0;
        for (int i = 0; i < len; i++) {
            totalSum += nums[i];
        }
        if (totalSum == x)
            return len;
        totalSum = totalSum - x;
        int left = 0;
        int right = 0;
        int sum = 0;
        int window = 0;
        while (right < len) {
            sum += nums[right];
            while (left < right && sum > totalSum) {
                sum -= nums[left];
                left++;
            }
            if (sum == totalSum)
                window = Math.max(window, right - left + 1);
            right++;
        }
        return window == 0 ? -1 : len - window;
    }
}
