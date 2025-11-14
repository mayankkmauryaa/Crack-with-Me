class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
}

// class Solution {
//     public int fib(int n) {
//         if(n<=1) return n;
//         int first = 0 ;
//         int second = 1;
//         int ans = 0;
//         for(int i=2; i<=n; i++){
//             ans= first + second;
//             first = second;
//             second = ans;
//         }
//         return ans;
//     }
// }

// class Solution {
//     public int fib(int n) {
//         if(n<=1) return n;
//         return fib(n-1) + fib(n-2);
//     }
// }