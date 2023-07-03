import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long sum1 = Arrays.stream(queue1).asLongStream().sum();
        long sum2 = Arrays.stream(queue2).asLongStream().sum();

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        Arrays.stream(queue1).boxed().forEach(q1::add);
        Arrays.stream(queue2).boxed().forEach(q2::add);

        while (sum1 != sum2) {
            if(answer > (queue1.length + queue2.length) * 2) return -1;
            
            if (sum1 < sum2) {
                Integer poll = q2.poll();

                sum2 -= poll;
                sum1 += poll;

                q1.add(poll);
            } else {
                Integer poll = q1.poll();

                sum1 -= poll;
                sum2 += poll;

                q2.add(poll);
            }

            answer++;
        }

        return answer;
    }
}