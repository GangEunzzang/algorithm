import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int K;
    private static boolean[] arr;
    private static int min = Integer.MAX_VALUE;
    private static int lionCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                lionCount++;
                arr[i] = true;
            }
        }

        solve();
    }

    private static void solve() {

        if (lionCount < K) {
            System.out.println(-1);
            return;
        }


        int nowLionCount = arr[0] ? 1 : 0;

        int start = 0;
        int end = 0;

        while (end < N && start < N && start <= end) {

            if (nowLionCount >= K) {
                min = Math.min(min, end - start + 1);
                if (arr[start++]) nowLionCount--;
                continue;
            }

            if (nowLionCount < K) {
                if (++end < N && arr[end]) nowLionCount++;
            }
        }

        System.out.println(min);

    }

}
