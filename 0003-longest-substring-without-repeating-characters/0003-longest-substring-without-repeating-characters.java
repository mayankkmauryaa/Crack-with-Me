class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxlen = 0;
        int freq[] = new int[256];
        while(left<=right && right < s.length()){
            char ch = s.charAt(right);
            freq[ch]++;
            while(freq[ch]>1){
                freq[s.charAt(left++)]--;
            }
            right++;
            maxlen = Math.max(maxlen, right - left);
        }
        return maxlen;
    }
}