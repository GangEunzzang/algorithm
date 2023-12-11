import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int[][] arr1, arr2;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        arr1 = new int[N][M];
        arr2 = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr1[i][j] = toInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr2[i][j] = toInt(st.nextToken());
            }
        }

        first:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    bfs(arr1[i][j], arr2[i][j], i, j);
                    break first;
                }
            }
        }

        System.out.println(check(arr1) ? "YES" : "NO");

    }

    private static boolean check(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void bfs(int beforeNum, int changeNum, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            arr1[poll[0]][poll[1]] = changeNum;

            for (int i = 0; i < 4; i++) {
                int mx = poll[0] + moveX[i];
                int my = poll[1] + moveY[i];
                if (mx < 0 || my < 0 || mx >= N || my >= M || visited[mx][my] || beforeNum != arr1[mx][my]) continue;

                visited[mx][my] = true;
                q.add(new int[]{mx,my});
            }
        }

    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
