class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int[] freq = new int[51];
        int ans = 0, sum = 0;
        for (int i = 0; i < apple.length; i++)
            sum += apple[i];
        for (int i = 0; i < capacity.length; i++)
            freq[capacity[i]]++;
        for (int i = 50; i > 0; i--) {
            while (freq[i] > 0) {
                sum -= i;
                freq[i]--;
                ans++;
                if (sum <= 0)
                    return ans;
            }
        }
        return ans;
    }
}