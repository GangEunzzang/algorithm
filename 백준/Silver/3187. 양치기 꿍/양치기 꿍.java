import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, wolf, sheep;
    static char[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        int sheepCount = 0;
        int wolfCount = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (arr[node.x][node.y] == 'v') wolfCount++;
            if (arr[node.x][node.y] == 'k') sheepCount++;

            for (int i = 0; i < 4; i++) {
                int mx = node.x + moveX[i];
                int my = node.y + moveY[i];

                if (mx < 0 || my < 0 || mx >= N || my >= M || visited[mx][my] || arr[mx][my] == '#') continue;

                visited[mx][my] = true;
                q.add(new Node(mx, my));
            }
        }

        if (sheepCount > wolfCount) sheep += sheepCount;
        else wolf += wolfCount;

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }




}
