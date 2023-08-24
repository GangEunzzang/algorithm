import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        while (N-- > 0) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        long result = 0;
        int max = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {

            Integer value = entry.getValue();
            Long key = entry.getKey();

            if (value > max) {
                result = key;
                max = value;
            }

            if (value == max && key < result) {
                result = key;
            }

        }

        System.out.println(result);

    }
}
