import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static long M;
    static int[] arr;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long start = 0;
        long end = arr[N - 1] * M;

        while (start <= end) {

            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                sum +=  mid / arr[i] ;
                if (sum >= M || arr[i] > mid) break;
            }

            if (sum >= M) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);

    }
}
