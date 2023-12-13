import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        int[] start = new int[2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        dfs(start[0], start[1]);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (arr[x][y] == 'P') answer++;

        for (int i = 0; i < 4; i++) {
            int mx = x + moveX[i];
            int my = y + moveY[i];

            if (mx < 0 || my < 0 || mx >= N || my >= M || visited[mx][my] || arr[mx][my] == 'X') continue;
            dfs(mx, my);
        }
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
