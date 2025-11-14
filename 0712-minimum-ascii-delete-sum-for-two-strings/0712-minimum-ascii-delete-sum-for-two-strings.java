class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        int sum =0;
        for(int i=1; i<=n ;i++){
            for(int j=1; j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int asciisum = dp[n][m];
        int total = 0;
        for(char ch : s1.toCharArray()) total+=ch;
        for(char ch : s2.toCharArray()) total+=ch;

        return total - 2 * asciisum;

    }
}

// answer = (sum of ASCII values in s1 + s2) – 2 * (ASCII sum of LCS)
