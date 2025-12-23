class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }
        int idx1 = 0, idx2 = 0;
        while (idx2 < nums.length / 2) {
            ans.add(pos.get(idx1));
            idx1++;
            ans.add(neg.get(idx2));
            idx2++;
        }
        for (int i = 0; i < nums.length; i++) nums[i] = ans.get(i);
        return nums;

    }
}
