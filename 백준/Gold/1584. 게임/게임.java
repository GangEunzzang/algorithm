import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        arr = new int[501][501];
        visited = new boolean[501][501];

        int N = Integer.parseInt(br.readLine());

        while (N --> 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int startX = Math.min(x1, x2);
            int endX = Math.max(x1, x2);
            int startY = Math.min(y1, y2);
            int endY = Math.max(y1, y2);

            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY ; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        while (M --> 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int startX = Math.min(x1, x2);
            int endX = Math.max(x1, x2);
            int startY = Math.min(y1, y2);
            int endY = Math.max(y1, y2);

            for (int i = startX; i <= endX; i++) {
                for (int j = startY; j <= endY ; j++) {
                    arr[i][j] = 2;
                }
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
        q.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == 500 && node.y == 500) return node.count;

            for (int i = 0; i < 4; i++) {
                int mx = node.x + moveX[i];
                int my = node.y + moveY[i];

                if (mx < 0 || my < 0 || mx > 500 || my > 500 || visited[mx][my] || arr[mx][my] == 2) continue;
                visited[mx][my] = true;
                q.add(new Node(mx, my, node.count + arr[mx][my]));
            }
        }

        return -1;
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
