class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][] seen = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    seen[i][j]=seen[i-1][j-1]+1;
                }
                else{
                    seen[i][j]=Math.max(seen[i-1][j], seen[i][j-1]);
                }
            }
        }
        int len = seen[n][m];
        return n - len + m - len;
    }
}

// class Solution {
//     public int minDistance(String word1, String word2) {
//         int len = longestCommonSubsequence(word1, word2);
//         int n = word1.length();
//         int m = word2.length();
//         return n - len + m - len;
//     }

//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         int [][] seen = new int[n+1][m+1];
//         for(int i=1; i<=n; i++){
//             for(int j=1; j<=m; j++){
//                 if(text1.charAt(i-1)==text2.charAt(j-1)){
//                     seen[i][j]=seen[i-1][j-1]+1;
//                 }
//                 else{
//                     seen[i][j]=Math.max(seen[i-1][j], seen[i][j-1]);
//                 }
//             }
//         }
//         return seen[n][m];
//     }
// }

/*
Example 1

word1 = “sea”, word2 = “eat”

LCS = “ea” → length 2
Deletions = (3-2) + (3-2) = 2

Example 2

word1 = “leetcode”, word2 = “etco”

LCS = “etco” → length 4
Deletions = (8-4) + (4-4) = 4
*/