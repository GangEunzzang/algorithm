import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] dp;

    private static int count1;
    private static int count2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[41];
        dp[0] = dp[1] = 1;

        dfs(N);
        dfs2();

        System.out.println(count1);
        System.out.println(count2);

    }

    static int dfs(int num) {
        if (num == 1 || num == 2){
            count1++;
            return 1;
        }

        int sum = dfs(num - 1) + dfs(num - 2);
        return sum;
    }

    static void dfs2() {
        for (int i = 2; i < N; i++) {
            count2++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }

    }

}
