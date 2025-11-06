class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        if(h==n) return max(piles);
        int low = 1;
        int high = max(piles);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = calHrs(piles, mid);
            if (hours <= h)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    int calHrs(int arr[], int val) {
        int hr = 0;
        for (int i : arr) {
            hr += Math.ceil((double)i / val);
        }
        return hr;
    }

    int max(int arr[]) {
        int ans = Integer.MIN_VALUE;
        for (int i : arr) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}