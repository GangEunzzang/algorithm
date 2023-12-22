import java.io.*;
import java.util.*;


public class Main {

    static int INF = 2_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st, st2;
    static StringBuilder sb = new StringBuilder();
    static int N, T;
    static int[] K, S;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        T = toInt(st.nextToken());
        N = toInt(st.nextToken());
        K = new int[N + 1];
        S = new int[N + 1];
        dp = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            S[i] = toInt(st.nextToken());
            K[i] = toInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if (j >= K[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - K[i]] + S[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }

                answer = Math.max(dp[i][j], answer);
            }
        }

        System.out.println(answer);



    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

