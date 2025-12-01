class Solution {
    public long maxRunTime(int n, int[] batteries) {
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