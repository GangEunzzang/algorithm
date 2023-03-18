import java.io.IOException;
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {

        int sum = 0;

        for (int i = 1; i <= 9; i++) {

            int finalI = i;
            if (Arrays.stream(numbers).filter(a -> a == finalI).findFirst().isEmpty()) {
                sum += i;
            }
            
        }
        
        return sum;
    }
}