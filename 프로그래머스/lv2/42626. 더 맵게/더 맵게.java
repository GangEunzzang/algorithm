import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int val : scoville) {
            priorityQueue.add(val);
        }

        int count = 0;

        while (priorityQueue.peek() < K && priorityQueue.size() >= 2) {
            Integer leastSpicy = priorityQueue.poll();
            Integer secondSpicy = priorityQueue.poll();
            priorityQueue.add(leastSpicy + secondSpicy * 2);
            count++;
        }

        if (priorityQueue.size() >= 2) {
            return count;
        }

        if (priorityQueue.peek() < K) {
            return -1;
        } else {
            return count;
        }
    }
}