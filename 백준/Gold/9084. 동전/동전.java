import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());  // 동전 종류
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target + 1];
            dp[0] = 1;

            for (int i = 0; i < N; i++) {
                for (int j = arr[i]; j <= target; j++) {
                    dp[j] += dp[j - arr[i]];
                }
            }
            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb);
    }
}
