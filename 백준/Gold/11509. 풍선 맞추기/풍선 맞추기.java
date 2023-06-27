import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();

        int idx = 0;
        int answer = 0;


        while (idx < N) {

            int height = arr[idx];

            if (map.containsKey(height)) {
                int value = map.get(height) - 1;
                if (value > 0) map.put(height, value);
                else map.remove(height);

            } else {
                answer++;
            }

            map.put(height - 1, map.containsKey(height - 1) ? map.get(height - 1) + 1 : 1);
            idx++;
        }

        System.out.println(answer);
    }

}