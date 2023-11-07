import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        int result = 0;
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();

            if (type.equals("+")) {
                map.put(name, map.getOrDefault(name, 0) + 1);
                continue;
            }

            if (!map.containsKey(name)) {
                result++;
                continue;
            }

            if (map.get(name) <= 1) {
                map.remove(name);
                continue;
            }

            map.put(name, map.get(name) - 1);

        }

        for (Integer value : map.values()) {
            result += value;
        }

        System.out.println(result);

    }
}