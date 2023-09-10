import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        long[] dp = new long[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_007;
        }

        System.out.println(dp[N]);
    }
}


