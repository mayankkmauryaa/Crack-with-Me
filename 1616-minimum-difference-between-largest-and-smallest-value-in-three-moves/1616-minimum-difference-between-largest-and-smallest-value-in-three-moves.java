class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        Arrays.sort(nums);
        int p1 = nums[n - 4] - nums[0]; // remove 3 largest
        int p2 = nums[n - 3] - nums[1]; // remove 2 largest, 1 smallest
        int p3 = nums[n - 2] - nums[2]; // remove 1 largest, 2 smallest
        int p4 = nums[n - 1] - nums[3]; // remove 3 smallest

        return Math.min(Math.min(Math.min(p1, p2), p3), p4);
    }
}

// For at most 3 moves, the four possibilities are:
// 1. Change the 3 largest numbers
// 2. Change 2 largest numbers and 1 smallest number
// 3. Change 1 largest number and 2 smallest numbers
// 4. Change the 3 smallest numbers
