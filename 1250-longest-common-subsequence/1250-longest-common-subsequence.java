class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int  n = text1.length();
        int  m = text2.length();
        int [][] seen = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                seen[i][j]=-1;
            }
        }
        return lcs(text1, text2, n, m, seen);
    }
    public int lcs(String s1, String s2, int n, int m, int[][] seen){
        if(m==0 || n==0) return 0;
        if(seen[n][m] != -1) return seen[n][m];
        if(s1.charAt(n-1)==s2.charAt(m-1)) return seen[n][m]=1+lcs(s1,s2,n-1,m-1,seen);
        return seen[n][m]=Math.max(lcs(s1,s2,n-1,m,seen),lcs(s1,s2,n,m-1,seen));
    }
}