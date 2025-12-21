class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxW = 0;
        int wtr = 0;
        int h = 0;
        int w = 0;

        while (l < r) {
            w = r - l;
            h = Math.min(height[l], height[r]);
            wtr = w * h;

            maxW = Math.max(maxW, wtr);

            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return maxW;
    }
}

