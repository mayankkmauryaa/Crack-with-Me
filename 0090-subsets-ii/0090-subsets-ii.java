class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        createSubset(0, nums, ans, subset);

        return ans;

    }

    private void createSubset(int idx, int nums[], List<List<Integer>> ans, List<Integer> sub) {
        // Collections.sort(sub);
        if (!ans.contains(sub)) {
            ans.add(new ArrayList<>(sub));
        }
        for (int i = idx; i < nums.length; i++) {
            sub.add(nums[i]);
            createSubset(i + 1, nums, ans, sub);
            sub.remove(sub.size() - 1);
        }

    }
}