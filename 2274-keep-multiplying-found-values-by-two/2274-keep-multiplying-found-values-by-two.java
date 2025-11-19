class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], 1);
        for (int i = 0; i < nums.length; i++)
            if (map.containsKey(original))
                original = original * 2;
        return original;
    }
}