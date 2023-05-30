import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        // 1 3 6 6 7 9

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            int num = arr[i] - arr[i - 1];
            list.add(num);
        }

        list.sort(Collections.reverseOrder());
        int result = 0;

        for (int i = K-1; i < N - 1; i++) {
            result += list.get(i);
        }

        System.out.println(result);

    }
}
