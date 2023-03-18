import java.io.IOException;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        return Arrays.stream(arr).filter(e -> e % divisor == 0).sorted().toArray().length > 0 ?
                Arrays.stream(arr).filter(e -> e % divisor == 0).sorted().toArray() 
                : new int[]{-1};
    }
}