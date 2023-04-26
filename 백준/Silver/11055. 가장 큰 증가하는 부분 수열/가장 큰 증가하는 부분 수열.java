import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static int[][] gearArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int[] arr = new int[A];
        int[] dp = new int[A];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        for (int i = 0; i < A; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + arr[i] > dp[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }
        

        System.out.println(Arrays.stream(dp).max().orElse(0));
    }
}