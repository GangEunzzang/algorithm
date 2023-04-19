import java.util.ArrayList;
import java.util.List;

class Solution {

    private static int[][] map;
    private static boolean[][] visited;

    private static int count;

    private static int[] moveX = {1, -1, 0, 0};
    private static int[] moveY = {0, 0, 1, -1};

    public int[] solution(String[] maps) {

        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {

            String s = maps[i];

            for (int j = 0; j < maps[i].length(); j++) {

                if (s.charAt(j) == 'X') {
                    continue;
                }

                map[i][j] = s.charAt(j) - 48;
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j, 0);
                    answer.add(count);
                    count = 0;
                }
            }
        }

        return answer.size() == 0 ? new int[]{-1} : answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int x, int y, int sum) {

        visited[x][y] = true;

        count += map[x][y];

        for (int i = 0; i < 4; i++) {
            if (x + moveX[i] > -1 && x + moveX[i] < map.length && map[x + moveX[i]][y] != 0 && !visited[x + moveX[i]][y]) {
                dfs(x + moveX[i], y, sum + map[x + moveX[i]][y]);
            }

            if (y + moveY[i] > -1 && y + moveY[i] < map[0].length && map[x][y + moveY[i]] != 0 && !visited[x][y + moveY[i]]) {
                dfs(x, y + moveY[i], sum + map[x][y + moveY[i]]);
            }
        }
    }
}