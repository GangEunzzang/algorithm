import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] arr, maxDp, minDp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][3];
        maxDp = new int[n + 1][3];
        minDp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= n; i++) {
            // 최대값
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + arr[i][1];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2];

            // 최소값
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + arr[i][1];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2];
        }


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[n][i]);
            min = Math.min(min, minDp[n][i]);
        }

        System.out.print(max + " " + min);

    }


}
