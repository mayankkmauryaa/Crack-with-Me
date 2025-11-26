class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int right = 0;
        int left = Integer.MIN_VALUE;
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canShip(weights, mid, days)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public boolean canShip(int arr[], int cap, int day) {
        int count = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] > cap) {
                count++;
                load = arr[i];
                if (count > day)
                    return false;
            } else {
                load += arr[i];
            }
        }
        return true;
    }

}