class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        compute(nums, new ArrayList<>());
        return ans;
    }

    public void compute(int nums[], List<Integer> list) {
        if (list.size() == nums.length)
            ans.add(new ArrayList<>(list));
        for (int num : nums) {
            if (list.contains(num))
                continue;
            list.add(num);
            compute(nums, list);
            list.remove(list.size() - 1);
        }
    }
}