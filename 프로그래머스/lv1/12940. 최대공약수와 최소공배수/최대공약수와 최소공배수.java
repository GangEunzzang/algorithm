class Solution {
    public int[] solution(int n, int m) {

        int mult = 0;

        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                mult = i;
            }
        }

        return new int[]{mult, n * m / mult};
    }
}