import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static char[][] arr;
    private static boolean visited[][];
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, arr[i][j]);
                    sum++;
                }
            }
        }

        System.out.println(sum);

    }

    private static void dfs(int x, int y, char pattern ) {
        visited[x][y] = true;

        if (pattern == '-' && y + 1 < M && arr[x][y+1] == '-') {
            dfs(x, y + 1, pattern);
        }

        if (pattern == '|' && x + 1 < N && arr[x + 1][y] == '|') {
            dfs(x + 1, y, pattern);
        }
    }
}


