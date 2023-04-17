import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] map;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new long[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        long dfs = dfs(0, 0);
        
        System.out.println(dfs);

    }

    public static long dfs(int x, int y) {

        if (dp[x][y] != -1) {
            return dp[x][y]; // 이미 계산한 결과가 있는 경우, 저장된 결과를 사용
        }

        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        dp[x][y] = 0;

        int dx = x + map[x][y];
        int dy = y + map[x][y];

        if (dx > N && dy > N) {
            return 0;
        }

        if (dx < N) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x + map[x][y], y));
        }

        if (dy < N) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x, y + map[x][y]));
        }

        return dp[x][y];

    }
}
