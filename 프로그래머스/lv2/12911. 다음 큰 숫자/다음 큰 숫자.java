class Solution {
    public int solution(int n) {

        long oneCountOfN = Integer.bitCount(n);

        for (int i = n + 1; i <= 1_000_000; i++) {
            long ontCountOfI = Integer.bitCount(i);
            if (oneCountOfN == ontCountOfI) {
                return i;
            }
        }
        return 0;
    }
}