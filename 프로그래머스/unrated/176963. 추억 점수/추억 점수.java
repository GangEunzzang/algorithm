import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> map = IntStream.range(0, name.length)
                .boxed()
                .collect(Collectors.toMap(i -> name[i], i -> yearning[i]));

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            
            for (int j = 0; j < photo[i].length; j++) {
                Integer val = map.getOrDefault(photo[i][j], 0);
                sum += val;
            }
            list.add(sum);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}