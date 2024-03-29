import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static int[][] map;
    private static boolean[][] visited;

    private static int[][][] dp;
    private static int[] moveX = {1, 0, 0, -1};
    private static int[] moveY = {0, -1, 1, 0};
    private static final int STRAIGHT_ROAD = 100;
    private static final int CURVE_ROAD = 500;
    private static int minValue = Integer.MAX_VALUE;
    private static int N;

    public int solution(int[][] board) {
        N = board.length;
        map = board.clone();
        visited = new boolean[N][N];
        dp = new int[N][N][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        bfs();
//        dfs(0, 0, 0, -1);
        return Math.min(Math.min(Math.min(dp[N - 1][N - 1][0], dp[N - 1][N - 1][1]), dp[N - 1][N - 1][2]), dp[N - 1][N - 1][3]);
    }

    private static void dfs(int startX, int startY, int nowValue, int direction) {
        if (startX == N - 1 && startY == N - 1) {
            minValue = Math.min(nowValue, minValue);
            return;
        }

        visited[startX][startY] = true;

        for (int i = 0; i < 4; i++) {
            int x = startX + moveX[i];
            int y = startY + moveY[i];

            if (x < 0 || y < 0 || x >= N || y >= N || map[x][y] == 1 || visited[x][y]) continue;

            int addedValue = STRAIGHT_ROAD;
            if (direction != -1 && direction != i) addedValue += CURVE_ROAD;

            if (nowValue + addedValue <= minValue) {
                visited[x][y] = true;
                dfs(x, y, nowValue + addedValue, i);
            }

            visited[x][y] = false;
        }
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, -1));
        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = dp[0][0][3] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int direction = node.direction;
            int nowValue = node.nowValue;
            
            if (node.x == N - 1 && node.y == N - 1) {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int x = node.x + moveX[i];
                int y = node.y + moveY[i];

                if (x < 0 || y < 0 || x >= N || y >= N || map[x][y] == 1) continue;

                int addedValue = STRAIGHT_ROAD;
                if (direction != -1 && direction != i) addedValue += CURVE_ROAD;

                if (nowValue + addedValue <= dp[x][y][i]) {
                    dp[x][y][i] = nowValue + addedValue;
                    queue.add(new Node(x, y, nowValue + addedValue, i));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int nowValue;
        int direction;

        public Node(int x, int y, int nowValue, int direction) {
            this.x = x;
            this.y = y;
            this.nowValue = nowValue;
            this.direction = direction;
        }
    }

}