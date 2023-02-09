import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M;
    static int N;
    static int K;

    static int[] nx = {0, 0, -1, +1};
    static int[] ny = {-1, +1, 0, 0};

    static int[][] map;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T != 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];

            visited = new boolean[M][N];

            int count = 0;

            for (int i = 0; i < K; i++) {

                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }


            for (int i = 0; i < M; i++) {

                for (int j = 0; j < N; j++) {

                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }

                }

            }
            sb.append(count).append("\n");
            T--;
        }

        System.out.println(sb);

    }

    static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int w = x + nx[i];
            int h = y + ny[i];

            if (w < 0 || h < 0 || w >= M || h >= N) {
                continue;
            }

            if (map[w][h] == 1 & !visited[w][h]) {
                dfs(w, h);
            }
        }
    }
}


