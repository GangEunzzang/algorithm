import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int lastMissile = targets[0][1];
        int answer = 1;

        for (int i = 1; i < targets.length; i++) {
            int startPoint = targets[i][0];
            int endPoint = targets[i][1];

            if (lastMissile <= startPoint) {
                answer++;
                lastMissile = endPoint;
            }
        }

        return answer;
    }
}

//	          [1, 4]
//            [4, 5]
//            [3, 7]
//            [4, 8]
//            [5, 12]
//            [11, 13]
//            [10, 14]