import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] arr = new int[5][5];
    private static boolean[][] visited = new boolean[5][5];
    private static boolean isFindApple;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        visited[r][c] = true;
        dfs(r, c, 0, 0);

        System.out.println(isFindApple ? 1 : 0);

    }

    private static void dfs(int x, int y, int depth, int eatenAppleCount) {
        if (isFindApple) return;

        if (depth == 3) {
            if (eatenAppleCount >= 2) {
                isFindApple = true;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int moveX = dx[i] + x;
            int moveY = dy[i] + y;
            if (moveX < 0 || moveY < 0 || moveX >= 5 || moveY >= 5 || visited[moveX][moveY] || arr[moveX][moveY] == -1 ) continue;

            visited[moveX][moveY] = true;
            dfs(moveX, moveY, depth + 1, arr[moveX][moveY] == 1 ? eatenAppleCount + 1 : eatenAppleCount);
            visited[moveX][moveY] = false;
        }

    }
}


