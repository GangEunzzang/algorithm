import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, min;
    static long[] dp = new long[1_000_001];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        min = 4;

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            if (min <= n) {
                for (int i = min; i <= n; i++) {
                    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;
                }
                min = n;
            }
            
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);

    }
}
