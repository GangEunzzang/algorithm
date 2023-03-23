import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int[] solution(String s) {

        String[] splitOfS = s.replace("{", "").replace("}", "").split(",");
        Map<Integer, Integer > map = new HashMap();

        for (int i = 0; i < splitOfS.length; i++) {
            int key = Integer.parseInt(splitOfS[i]);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        return map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}