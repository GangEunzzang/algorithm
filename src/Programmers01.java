public class Programmers01 {
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;

            if (b >= a) {
                for (int i = a; i <= b; i++) {
                    answer += i;
                }
                return answer;
            } else {
                for (int i = b; i <= a; i++) {
                    answer += i;
                }
                return answer;
            }
        }
    }

}
