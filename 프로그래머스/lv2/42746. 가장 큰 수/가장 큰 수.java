import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers).allMatch(i -> i == 0) ? "0" :
                Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo((o1 + o2)))
                .collect(Collectors.joining());

    }
}