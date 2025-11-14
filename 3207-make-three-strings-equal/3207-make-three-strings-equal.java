class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int x = s1.length();
        int y = s2.length();
        int z = s3.length();

        int minlen = Math.min(x, Math.min(y,z));
        int sum = x+y+z;

        if (s1.charAt(0) != s2.charAt(0) || s1.charAt(0) != s3.charAt(0) || s2.charAt(0) != s3.charAt(0)) return -1;

        for(int i = 0; i< minlen; i++) {
            if(s1.charAt(i)==s2.charAt(i) && s2.charAt(i)==s3.charAt(i)) sum-=3;
            else break;
        }

        return sum;
    }
}
