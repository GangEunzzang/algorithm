import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static int N;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int min = Integer.MAX_VALUE;
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs( 0, 0);

        System.out.println(min);
    }

    private static void dfs(int flowerCount, int sum) {

        if (flowerCount == 3){
            min = Math.min(sum, min);
            return;
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if (!visited[i][j] && check(i, j)) {
                    visited[i][j] = true;
                    dfs(flowerCount + 1, sum + sum(i, j));
                    visitClear(i,j);
                    visited[i][j] = false;
                }
            }
        }

    }

    private static int sum(int x, int y) {
        int sum = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int dx = x + moveX[i];
            int dy = y + moveY[i];
            visited[dx][dy] = true;
            sum += arr[dx][dy];
        }
        return sum;
    }

    private static void visitClear(int x, int y) {
        IntStream.range(0, 4).forEachOrdered(i -> visited[x + moveX[i]][y + moveY[i]] = false);
    }

    private static boolean check(int x, int y) {
        return IntStream.range(0, 4).noneMatch(i -> visited[x + moveX[i]][y + moveY[i]]);
    }

}