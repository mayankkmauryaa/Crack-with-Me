class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        createSubset(0, nums, ans, subset);

        return ans;

    }

    private void createSubset(int idx, int nums[], List<List<Integer>> ans, List<Integer> sub) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[idx]);
        createSubset(idx + 1, nums, ans, sub);

        sub.remove(sub.size() - 1);
        createSubset(idx + 1, nums, ans, sub);

    }
}