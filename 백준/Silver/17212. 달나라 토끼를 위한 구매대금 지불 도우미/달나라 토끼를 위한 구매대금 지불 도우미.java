import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Integer> coins = List.of(1, 2, 5, 7);
    static int[] dp;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        dp = new int[100001];
        Arrays.fill(dp, 100000);
        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;
        dp[7] = 1;

        for (int i = 3; i <= N; i++) {
            for (int j = 0; j < 4; j++) {
                Integer coin = coins.get(j);
                if (i - coin < 0) break;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        System.out.println(dp[N]);
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




