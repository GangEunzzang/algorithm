
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String val = words[i];
            String beforeVal = words[i - 1];

            if (val.charAt(0) != beforeVal.charAt(beforeVal.length() - 1)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            
            if (set.contains(val)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            set.add(val);
        }

        return new int[]{0,0};
    }
}