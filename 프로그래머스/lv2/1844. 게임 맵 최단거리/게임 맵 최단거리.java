import java.util.*;
class Solution {

    private int[][] map;
    private boolean[][] visited;

    private int[] moveOfN = {0, 0, -1, 1};
    private int[] moveOfM = {1, -1, 0, 0};

    public int solution(int[][] maps) {

        map = new int[maps.length][maps[0].length];
        visited = new boolean[maps.length][maps[0].length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (maps[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        bfs(0, 0);

        return map[map.length-1][map[0].length-1] == 0 ? -1 : map[map.length-1][map[0].length-1];
    }

    private void bfs(int n, int m) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, m));
        map[n][m] = 1;

        while (!queue.isEmpty()) {

            Pair poll = queue.poll();

            for (int i = 0; i < 4; i++) {

                int movingOfN = poll.getX() + moveOfN[i];
                int movingOfM = poll.getY() + moveOfM[i];

                if (movingOfN < 0 || movingOfM < 0 || movingOfN >= map.length || movingOfM >= map[0].length) {
                    continue;
                }

                if (visited[movingOfN][movingOfM]) {
                    continue;
                }

                queue.add(new Pair(movingOfN, movingOfM));
                visited[movingOfN][movingOfM] = true;
                map[movingOfN][movingOfM] = map[poll.getX()][poll.getY()] + 1;
            }
        }
    }

    private static class Pair {

        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
    
