class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1; // can be 0 but, Constraints: 1 <= position[i] <= 109 so:minimum possible distance -> 1
        int high = position[n - 1] - position[0]; //dist b/w left & right ball
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(position, m, mid)) { // mid is possible, try for bigger
                ans = mid;
                low = mid + 1;
            } else {            // can't place m balls, reduce size
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(int[] arr, int m, int dist) {
        int count = 1; // first ball at position[0]
        int lastPos = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPos >= dist) {
                count++;
                lastPos = arr[i];
            }
            if (count >= m)
                return true;
        }
        return false;
    }
}
