class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        compute(nums, ans, new ArrayList<>());
        return ans;
    }

    static void compute(int nums[], List<List<Integer>> ans, List<Integer> list) {
        if (list.size() == nums.length)
            ans.add(new ArrayList<>(list));
        for (int num : nums) {
            if (list.contains(num))
                continue;
            list.add(num);
            compute(nums, ans, list);
            list.remove(list.size() - 1);
        }
    }
}