class Solution {

    private static long[] dp = new long[100001];


    public int solution(int n) {
        dp[1] = dp[2] = 1;
        fibonaci(n);
        return (int) (dp[n] % 1234567);
    }

    private static long fibonaci(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fibonaci(n-1) % 1234567 + fibonaci(n-2) % 1234567;
        return dp[n];
    }
}