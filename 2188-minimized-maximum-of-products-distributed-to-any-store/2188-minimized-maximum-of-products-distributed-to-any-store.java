class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int min = 1;
        int max = quantities[0];
        for (int q : quantities)
            max = Math.max(q, max);

        while (min <= max) {
            int mid = min + (max - min) / 2;
            // mid works → try smaller
            if (canDistribute(quantities, n, mid))
                max = mid - 1;
            // mid too small → increase
            else
                min = mid + 1;
        }
        return min;
    }

    // It requires ceil(q / mid) stores.
    // needed_stores = Σ ceil(quantities[i] / mid)

    public boolean canDistribute(int[] quantities, int n, int mid) {
        int count = 0;
        for (int q : quantities) {
            // count += Math.ceil(q/mid);
            count += (q + mid - 1) / mid;
            // just inc. q  by mid so it gets it ceil value but decreses by 1 so that it should not perfectly sync to next possible number
            if (count > n)
                return false;
        }
        return count <= n;
    }
}
