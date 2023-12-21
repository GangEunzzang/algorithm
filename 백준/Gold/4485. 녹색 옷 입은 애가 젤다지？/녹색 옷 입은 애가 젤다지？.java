import java.io.*;
import java.util.*;


public class Main {

    static int INF = 2_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        int idx = 1;

        while (true) {
            N = toInt(br.readLine());
            if (N == 0) break;

            arr = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = toInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(idx++).append(": ").append(bfs()).append("\n");
        }

        System.out.println(sb);

    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>((Comparator.comparingInt(o -> o.rupee)));
        q.add(new Node(0, 0, arr[0][0]));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == N - 1 && node.y == N - 1) {
                return node.rupee;
            }

            for (int i = 0; i < 4; i++) {
                int mx = node.x + moveX[i];
                int my = node.y + moveY[i];

                if (mx < 0 || my < 0 || mx >= N || my >= N || visited[mx][my]) continue;

                visited[mx][my] = true;
                q.add(new Node(mx, my, node.rupee + arr[mx][my]));
            }
        }

        return 0;

    }

    static class Node {
        int x;
        int y;
        int rupee;

        public Node(int x, int y, int rupee) {
            this.x = x;
            this.y = y;
            this.rupee = rupee;
        }
    }
    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

