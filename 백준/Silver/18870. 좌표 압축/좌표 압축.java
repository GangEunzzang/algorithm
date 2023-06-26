import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] original = arr.clone();
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], rank++);
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(original[i])).append(" ");
        }

        System.out.println(sb);
    }
}
