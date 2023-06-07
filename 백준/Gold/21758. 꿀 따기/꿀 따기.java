import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr;
    private static int[] sum;

    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum[i] = num + sum[i - 1];
        }

        solve();
        System.out.println(max);
    }

    public static void solve() {

        //벌통이 왼쪽
        for (int i = 2; i <= N - 1; i++) {
            int num = sum[N] - arr[1] - arr[i] + sum[N] - sum[i];
            max = Math.max(num, max);
        }

        // 벌통이 오른쪽
        for (int i = 2; i <= N - 1; i++) {
            int num = sum[N - 1] - arr[i] + sum[i - 1];
            max = Math.max(num, max);
        }

        // 벌통이 가운데서 왔다갔다
        for (int i = 2; i <= N - 1; i++) {
            int num = sum[N - 1] - sum[i-1] + sum[i] - sum[1];
            max = Math.max(num, max);

        }

    }
}
