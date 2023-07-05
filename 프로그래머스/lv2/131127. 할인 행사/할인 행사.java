import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        int result = 0;

        Map<String, Integer> wantCount = new HashMap<>();

        first:
        for (int i = 0; i < discount.length - 9; i++) {

            for (int k = 0; k < want.length; k++) wantCount.put(want[k], number[k]);

            for (int j = i; j < i + 10; j++) {
                if (!wantCount.containsKey(discount[j])) continue first;
                wantCount.put(discount[j], wantCount.get(discount[j]) - 1);
            }

            boolean check = wantCount.values().stream().anyMatch(num -> num > 0);
            if(!check) result++;

        }

        return result;
    }
}