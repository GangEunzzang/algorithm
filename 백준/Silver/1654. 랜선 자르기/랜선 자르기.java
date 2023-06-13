import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int K;
    private static int N;
    private static int[] arr;
    private static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long start = 1;
        long end = arr[K - 1];

        while (start <= end) {
            long mid = (start + end) / 2;
            int count = 0;

            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
                if (count >= N) break;
            }

            if (count >= N) {
                start = mid + 1;
                max = mid;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(max);

    }

}
