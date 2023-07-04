import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

class Solution {

    // 보조 컨테이너 stack
    public int solution(int[] order) {

        Queue<Integer> seq = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer integer : order) seq.add(integer);

        int idx = 1;

        /**
         * 1. seq에는 추출해야하는 순서가 들어있음
         * 2. stack에서 seq와 일치하면 둘 다 하나씩 빼주며 반복
         * 3. idx와 seq가 일치하면 seq에서 제거
         */

        while (true) {

            boolean check = false;

            while (!stack.isEmpty() && Objects.equals(stack.peek(), seq.peek())) {
                seq.poll();
                stack.pop();
                check = true;
            }

            if(check) continue;

            if (!seq.isEmpty() && seq.peek() == idx) seq.poll();
            else stack.add(idx);

            if (idx++ > order.length) break;
        }

        return order.length - seq.size();
    }
}