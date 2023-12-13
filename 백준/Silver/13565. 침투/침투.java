import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < M; i++) {
            if (!visited[0][i] && arr[0][i] == 0) {
                dfs(0, i);
            }
        }

        for (int i = 0; i < M; i++) {
            if (visited[N-1][i]) {
                System.out.println("YES");
                return;
            }
        }
        
        System.out.println("NO");

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int mx = x + moveX[i];
            int my = y + moveY[i];

            if (mx < 0 || my < 0 || mx >= N || my >= M || visited[mx][my] || arr[mx][my] == 1) continue;
            dfs(mx, my);
        }
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
