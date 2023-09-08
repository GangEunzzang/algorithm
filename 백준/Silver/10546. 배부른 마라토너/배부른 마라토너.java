import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine()) * 2 -1;
        while (N-- > 0) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
