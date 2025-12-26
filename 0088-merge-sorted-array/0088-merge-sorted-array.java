class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int total = m + n - 1;
        while (len2 >= 0) {
            if (len1 >= 0 && nums1[len1] > nums2[len2]) {
                nums1[total] = nums1[len1];
                len1--;
            } else {
                nums1[total] = nums2[len2];
                len2--;
            }
            total--;
        }
    }
}