import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int N, K, max;
    static long answer;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        K = toInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = toInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        binarySearch();

        System.out.println(answer);

    }

    private static void binarySearch() {
        long start = 1;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i = 0; i < N; i++) {
                count += arr[i] / mid;
            }

            if (count >= K) {
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }

        answer = end;
    }

    static int toInt(String num) {
        return Integer.parseInt(num);
    }
}
