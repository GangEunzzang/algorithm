import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;

    static int[] hCoordinate = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] wCoordinate = {0, 0, -1, 1, -1, 1, -1, 1};

    static int n;
    static int m;
    static int w;
    static int h ;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            n = w;
            m = h;

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


    public static void dfs(int h, int w) {

        if (h == -1 || w == -1 || h == m || w == n) {
            return;
        }

        if (graph[h][w] == 0) {
            return;
        }

        graph[h][w] = 0;

        for (int i = 0; i < 8; i++) {
            int x = h + hCoordinate[i];
            int y = w + wCoordinate[i];
            dfs(x, y);
        }
    }
}
