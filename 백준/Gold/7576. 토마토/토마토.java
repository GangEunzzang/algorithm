import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, 1, -1};
    private static int n;
    private static int m;
    private static List<Integer> startN = new ArrayList<>();
    private static List<Integer> startM = new ArrayList<>();
    private static int totalVisitsCount;
    private static int visitedCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    startN.add(i);
                    startM.add(j);
                    map[i][j] = 1;
                } else if (num == 0){
                    map[i][j] = num;
                    totalVisitsCount++;
                } else {
                    map[i][j] = num;
                }
            }
        }

        if (totalVisitsCount == 0) {
            System.out.println(0);
            return;
        }

        bfs();

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        System.out.println(visitedCount == totalVisitsCount ? max-1 : -1);

    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < startN.size(); i++) {
            q.add(new Node(startN.get(i), startM.get(i), 1));
            visited[startN.get(i)][startM.get(i)] = true;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            int count = node.getCount();

            map[x][y] = count;

            for (int i = 0; i < 4; i++) {
                int nx = x + moveX[i];
                int ny = y + moveY[i];

                if (nx >= n || ny >= m || nx < 0 || ny < 0 || visited[nx][ny] || map[nx][ny] == -1) {
                    continue;
                }
                q.add(new Node(nx, ny, count + 1));
                visited[nx][ny] = true;
                visitedCount++;
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