import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[1];
        });

        int point = -33333;

        for (int i = 0; i < routes.length; i++) {
            if (point >= routes[i][0] && point <= routes[i][1]) continue;

            answer++;
            point = routes[i][1];
        }

        return answer;
    }
}