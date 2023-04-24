import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, 1, -1};
    private static int n;
    private static int m;

    private static boolean isCheck;
    private static int startN;
    private static int startM;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 2) {
                    startN = i;
                    startM = j;
                    map[i][j] = 1;
                } else if (num == 1) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = num;
                }

            }
        }

        bfs();

        for (
                int i = 0;
                i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] != 1) {
                    continue;
                }

                if (Math.abs(startN - i) > 1 && Math.abs(startM - i) > 1) {
                    map[i][j] = -1;
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for (
                int i = 0;
                i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startN, startM, 0));
        visited[startN][startM] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            int count = node.getCount();

            map[x][y] = count;

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx >= n || ny >= m || nx < 0 || ny < 0 || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                q.add(new Node(nx, ny, count + 1));
                visited[nx][ny] = true;
            }
        }
    }


    private static class Node {
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        private int x;
        private int y;

        private int count;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }

}