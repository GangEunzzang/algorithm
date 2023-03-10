
class Solution {
    public int solution(int number, int limit, int power) {

        int[] dp = new int[100001];
        for (int i = 1; i <= 100000; i++) {

            int count = 0;

            for (int j = 1; j  * j <= i; j++) {

                if (j * j == i) {
                    count++;
                } else if (i % j == 0) {
                    count += 2;
                }
            }

            dp[i] = count;
        }

        int result = 0;

        for (int i = 1; i <= number; i++) {
            if (dp[i] > limit) {
                result += power;
            }  else {
                result += dp[i];
            }
        }

        return result;
    }
}