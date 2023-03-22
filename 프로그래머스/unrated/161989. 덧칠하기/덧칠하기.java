class Solution {
    public int solution(int n, int m, int[] section) {

        int max = 0;
        int count = 0;

        for (int num : section) {
            if (max <= num) {
                max = num + m;
                count++;
            }
        }

        return count;
    }
}