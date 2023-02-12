import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visited;

    static int N;

    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String S = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = S.charAt(j);
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        count = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }

    static void dfs(int a, int b) {

        visited[a][b] = true;

        for (int i = 0; i < 4; i++) {

            int X = a + nx[i];
            int Y = b + ny[i];

            if (X < 0 || Y < 0 || X >= N || Y >= N) {
                continue;
            }

            if (map[a][b] == map[X][Y] && !visited[X][Y]) {
                dfs(X, Y);
            }

        }
    }

}
