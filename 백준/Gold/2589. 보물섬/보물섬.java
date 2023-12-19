import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, max;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        visited = new boolean[N][M];

        // 1 육지, 0 바다
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) == 'L' ? 1 : 0;
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);

    }


    private static void bfs(int startX, int startY) {
        visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            max = Math.max(max, node.count);

            for (int i = 0; i < 4; i++) {
                int mx = node.x + moveX[i];
                int my = node.y + moveY[i];

                if (mx < 0 || my < 0 || mx >= N || my >= M || arr[mx][my] == 0 || visited[mx][my]) continue;

                q.add(new Node(mx, my, node.count + 1));
                visited[mx][my] = true;
            }
        }
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


}

