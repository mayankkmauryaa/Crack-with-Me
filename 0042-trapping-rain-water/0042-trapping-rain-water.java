class Solution {
    public int trap(int[] height) {
        int total = 0;
        int left = 0;
        int right = height.length-1;
        int lmax = 0;
        int rmax = height[right];
        while(left<right){
            if(height[left]<=height[right]){
                if(lmax > height[left]) total += lmax-height[left];
                else lmax = height[left];
                left++;
            } else {
                if(rmax > height[right]) total += rmax-height[right];
                else rmax = height[right];
                right--;
            }
        }
        return total;
    }
}