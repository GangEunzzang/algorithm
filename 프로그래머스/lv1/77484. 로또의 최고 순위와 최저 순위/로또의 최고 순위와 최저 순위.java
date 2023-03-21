import java.io.IOException;
import java.util.*;


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCount = 0;
        int matchCount = 0;

        long count = Arrays.stream(lottos).asDoubleStream().filter(a -> a == 0).count();
        if (count == 6) {
            return new int[]{1, 6};
        }

        for (int i = 0; i < lottos.length; i++) {
            int lotto = lottos[i];

            if (lotto == 0) {
                zeroCount++;
                continue;
            }

            boolean isVal = Arrays.stream(win_nums).anyMatch(val -> val == lotto);

            if (isVal) {
                matchCount++;
            }
        }


        switch (matchCount) {
            case 6 :
                return new int[]{1, 1};
            case 5:
                return new int[]{2 - zeroCount,2};
            case 4:
                return new int[]{3 - zeroCount, 3};
            case 3:
                return new int[]{4 - zeroCount, 4};
            case 2:
                return new int[]{5 - zeroCount, 5};
            default:
                return new int[]{6 - zeroCount, 6};
        }
    }
}