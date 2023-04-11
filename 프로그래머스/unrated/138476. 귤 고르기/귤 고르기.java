import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1 );
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        
        int count = 0;
        int index = 0;

        while (k > 0) {
            Integer val = list.get(index);
            k -= val;
            count++;
            index++;
        }

        return count;
    }
}