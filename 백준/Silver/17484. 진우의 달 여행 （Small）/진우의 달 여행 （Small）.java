import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;
    static int N, M;
    static int min = INF;
    static int[][] arr;
    static int[] moveY = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken()); // 세로
        M = toInt(st.nextToken()); // 가로

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = toInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dfs(0, i, arr[0][i], 999);
        }

        System.out.println(min);
    }

    static void dfs(int x, int y, int sum, int dir) {
        if (x == N -1) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int my = y + moveY[i];

            if (dir == i) continue;
            if (my < 0 || my >= M) continue;

            dfs(x + 1, my, sum + arr[x+1][my], i);
        }
    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}
