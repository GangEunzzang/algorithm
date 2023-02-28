import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.DoubleToIntFunction;

public class Main {

    private static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(rf(N));
    }
    
    private static int rf(int N) {

        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(rf(N / 3), Math.min(rf(N / 2), rf(N - 1))) + 1;
                
            } else if (N % 3 == 0) {
                dp[N] = Math.min(rf(N / 3), rf(N - 1)) + 1;
                
            } else if (N % 2 == 0) {
                dp[N] = Math.min(rf(N / 2), rf(N - 1)) + 1;
                
            } else {
                dp[N] = rf(N - 1) + 1;
            }
        }
        
        return dp[N];
    }
}

