import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(clothes).forEach(strings -> map.put(strings[1], map.getOrDefault(strings[1], 0) + 1));
        return map.values().stream().mapToInt(value -> value + 1).reduce(1, (a, b) -> a * b) - 1;

    }
}