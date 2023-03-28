import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static boolean[][] visited;
    private static int[][] map;

    private static int width;

    private static int height;

    private static int[] moveOfN = {0, 0, 1, -1};
    private static int[] moveOfM = {1, -1, 0, 0};

    public int solution(int[][] maps) {

        width = maps.length - 1;
        height = maps[0].length - 1;

        map = new int[maps.length][maps[0].length];
        visited = new boolean[maps.length][maps[0].length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        bfs(0, 0, 0);


        return map[width][height] == 0 ? -1 : map[width][height];
    }

    private static void dfs(int n, int m, int count) {

        if (visited[n][m]) {
            return;
        }

        visited[n][m] = true;

        if (map[n][m] <= count + 1) {
            map[n][m] = count + 1;
        }

        for (int i = 0; i < 4; i++) {

            int arrivalOfN = n + moveOfN[i];
            int arrivalOfM = m + moveOfM[i];

            if (arrivalOfN < 0 || arrivalOfM < 0 || arrivalOfN > width || arrivalOfM > height) {
                continue;
            }

            if (visited[arrivalOfN][arrivalOfM]) {
                continue;
            }

            dfs(arrivalOfN, arrivalOfM, map[n][m]);
        }
    }

    private static void bfs(int n, int m, int count) {
        Queue<Pair> queue = new LinkedList();
        queue.add(new Pair(n,m));

        while (!queue.isEmpty()) {

            Pair poll = queue.poll();

            for (int i = 0; i < 4; i++) {

                int arrivalOfN = poll.getX() + moveOfN[i];
                int arrivalOfM = poll.getY() + moveOfM[i];

                if (arrivalOfN < 0 || arrivalOfM < 0 || arrivalOfN > width || arrivalOfM > height) {
                    continue;
                }

                if (visited[arrivalOfN][arrivalOfM]) {
                    continue;
                }

                queue.add(new Pair(arrivalOfN, arrivalOfM));
                map[arrivalOfN][arrivalOfM] = map[poll.getX()][poll.getY()] + 1;
                visited[arrivalOfN][arrivalOfM] = true;
            }
        }
    }
    
    private static class Pair {

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY(){
            return y;
        }

    }
}