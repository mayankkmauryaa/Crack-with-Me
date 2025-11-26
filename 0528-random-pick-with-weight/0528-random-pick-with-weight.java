class Solution {

    private int[] prefix;
    private int total;

    public Solution(int[] w) {
        int n = w.length;
        prefix = new int[n];
        prefix[0] = w[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }

        total = prefix[n - 1];
    }

    public int pickIndex() {
        int target = (int) (Math.random() * total) + 1;

        int l = 0;
        int r = prefix.length;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (prefix[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */