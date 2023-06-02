import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][2];
        int[][] dp = new int[N + 1][100];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 100; j++) {
                if (arr[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - arr[i][0]] + arr[i][1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        System.out.println(dp[N][99]);

    }
}
