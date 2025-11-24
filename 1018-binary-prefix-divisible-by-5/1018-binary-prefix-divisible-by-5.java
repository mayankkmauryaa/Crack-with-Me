class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int dec = 0;
        for (int bit : nums) {
            dec = (dec * 2 + bit) % 5;
            ans.add(dec == 0);
        }
        return ans;
    }
}