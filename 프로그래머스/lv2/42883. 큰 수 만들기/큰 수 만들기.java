import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] chars = number.toCharArray();

        int idx = 0;
        char max = 0;

        for (int i = 0; i < number.length() - k; i++) {
            
            max = 0;

            for (int j = idx; j <= k + i; j++) {
                if (chars[j] > max) {
                    max = chars[j];
                    idx = j+1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}