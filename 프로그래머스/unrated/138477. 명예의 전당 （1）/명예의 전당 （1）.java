import java.io.IOException;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            Integer num = score[i];
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
                answer[i] = priorityQueue.peek();
                continue;
            }

            if (priorityQueue.peek() <= num) {
                priorityQueue.poll();
                priorityQueue.add(num);
                answer[i] = priorityQueue.peek();
            } else {
                answer[i] = priorityQueue.peek();
            }
            
        }
        
        return answer;
    }
}