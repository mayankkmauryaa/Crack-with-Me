class Solution {
    public int[] shuffle(int[] nums, int n) {
        int idx = 0;
        int arr[] = new int[nums.length];
        for (int i = 0; i < n; i++) {
            arr[idx] = nums[i];
            idx++;
            arr[idx] = nums[n + i];
            idx++;
        }
        return arr;
    }
}