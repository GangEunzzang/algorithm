import java.util.Arrays;

class Solution {
    
    public int solution(int[] topping) {
        int rightCount = 0;
        int leftCount = (int) Arrays.stream(topping).distinct().count();

        int[] leftNumberCount = new int[10_001];
        int[] rightNumberCount = new int[10_001];
        for (int i : topping) leftNumberCount[i]++;

        int idx = topping.length;

        int answer = 0;

        while (idx-- > 0) {
            if (--leftNumberCount[topping[idx]] == 0) leftCount--;
            if (rightNumberCount[topping[idx]]++ == 0) rightCount++;
            if (leftCount == rightCount) answer ++;
        }

        return answer;
    }


}