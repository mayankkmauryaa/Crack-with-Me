class Solution {
    public long maximumHappinessSum1(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int n = happiness.length - 1;
        for (int i = 0; i < k; i++) {
            int val = happiness[n - i] - i;
            if (val > 0)
                ans += val;
            else
                break;
        }
        return ans;
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count = 0;
        long res = 0;
        for (int i = happiness.length - 1; i >= happiness.length - k; i--) {
            if (happiness[i] + count > 0) {
                res += (long) (happiness[i] + count);
            }
            count--;
        }

        return res;
    }
}