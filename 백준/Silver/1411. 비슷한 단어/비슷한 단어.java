import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] sumArr = new int[101];
        sumArr[2] = 1;

        for (int i = 3; i <= 100; i++) {
            sumArr[i] += sumArr[i-1] + i-1;
        }

        Map<String, Integer> pairMap = new HashMap<>();

        while (N-- > 0) {
            int idx = 0;
            Map<Character, Integer> alphabets = new HashMap<>();

            char[] chars = br.readLine().toCharArray();

            StringBuilder sb = new StringBuilder();

            for (char alphabet : chars) {
                if (alphabets.containsKey(alphabet)) {
                    sb.append(alphabets.get(alphabet));
                } else {
                    sb.append(idx);
                    alphabets.put(alphabet, idx++);
                }
            }

            pairMap.put(sb.toString(), pairMap.getOrDefault(sb.toString(), 0) + 1);
        }

        int sum = pairMap.values().stream().mapToInt(value -> sumArr[value]).sum();

        System.out.println(sum);

    }

}
