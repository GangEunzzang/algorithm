import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int usedInvincibilityCount = 0;
        int idx = 0;

        for (int i : enemy) {
            pq.add(i);
            n -= i;

            if (n < 0) {
                if (usedInvincibilityCount < k) {
                    usedInvincibilityCount++;
                    n += pq.poll();
                } else {
                    break;
                }
            }
            idx++;
        }

        return idx;
    }
}