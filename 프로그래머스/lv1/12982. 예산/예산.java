import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {

        int sum = 0;
        Arrays.sort(d);
        int count = 0;

        for (int j = 0; j < d.length; j++) {
            int i = d[j];
            sum += i;

            if (sum > budget) {
                break;
            }
            count++;
        }

        return count;
    }
}