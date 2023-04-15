import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int[][] map;
    private static boolean[][] visited;

    private static int N;
    private static int M;

    private static int count = 0;

    private static int[] moveX = new int[]{-1, 1, 0, 0};
    private static int[] moveY = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int foodTrashCount = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];



        for (int i = 0; i < foodTrashCount; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 1;
        }
        
        int maxFoodSize = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    int count = dfs(i, j);
                    if (count > maxFoodSize) {
                        maxFoodSize = count;
                    }
                }
                count = 0;
            }
        }

        System.out.println(maxFoodSize);
    }

    public static int dfs(int x, int y) {

        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {

            if (x + moveX[i] < 0 || y + moveY[i] < 0 || x + moveX[i] >= N || y + moveY[i] >= M) {
                continue;
            }

            if (!visited[x + moveX[i]][y + moveY[i]] && map[x + moveX[i]][y + moveY[i]] == map[x][y]) {
                dfs(x + moveX[i], y + moveY[i]);
            }
        }

        return count;
    }
}


