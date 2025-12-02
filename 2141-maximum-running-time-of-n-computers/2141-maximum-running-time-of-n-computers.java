class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int bat : batteries)
            sum += bat;
        long low = 0;
        long high = sum / n;
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            if (canCharge(batteries, mid, n)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean canCharge(int arr[], long x, int n) {
        long total = 0;
        for (int val : arr) {
            total += Math.min(val, x);
            if (total >= x * n)
                return true;
        }
        return total >= x * n;
    }

    public long maxRunTime1(int n, int[] batteries) {
        long total = 0;
        for (int bat : batteries)
            total += bat;
        Arrays.sort(batteries);
        int x = batteries.length;
        for (int i = x - 1; i >= 0; i--) {
            if (batteries[i] > total / n) {
                total -= batteries[i];
                n--;
            } else
                break;
        }
        return total / n;
    }
}