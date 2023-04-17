import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.*;

public class Main {

    private static int[] dp;

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            sb.append(dp[num] + "\n");
        }
        
        System.out.println(sb);
    }

}
