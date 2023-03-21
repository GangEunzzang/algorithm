class Solution {
    public int solution(int n) {

        boolean[] prime = new boolean[n + 1];

        if (n < 2) return 1;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == true) {
                continue;
            }

            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }

        int count = 0;

        for (int i = 2; i <= n; i++) {

            if (!prime[i]) {
                count++;
            }
        }
        return count;
    }
}