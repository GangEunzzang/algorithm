import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] moveY = {0, 0, -1, 1, -1, 1, -1, 1};
    static int w;
    static int h;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            visited = new boolean[h][w];
            graph = new int[h][w];

            for (int i = 0; i < h; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    graph[i][j] = num;
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && graph[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }


    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int mx = x + moveX[i];
            int my = y + moveY[i];

            if (mx < 0 || my < 0 || mx >= h || my >= w || graph[mx][my] == 0 || visited[mx][my]) continue;

            dfs(mx, my);
        }
    }
}
