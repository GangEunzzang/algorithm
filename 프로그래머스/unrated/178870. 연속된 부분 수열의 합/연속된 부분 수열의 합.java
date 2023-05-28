import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int start = 0;
        int end = 0;
        int nowSum = sequence[0];
        Map<Integer, int[]> map = new HashMap<>();

        while (start <= end && start < sequence.length && end < sequence.length) {
            if (nowSum == k) {
                map.putIfAbsent(end - start, new int[]{start, end});
                nowSum -= sequence[start++];
                continue;
            };

            if (nowSum < k) {
                if (end + 1 >= sequence.length) {
                    break;
                }
                nowSum += sequence[++end];
            } else {
                nowSum -= sequence[start++];
            }
        }

        int min = Integer.MAX_VALUE;
        for (Integer i : map.keySet()) {
            min = Math.min(min, i);
        }
        return map.get(min);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println("solution1 = " + solution1);
    }
}

