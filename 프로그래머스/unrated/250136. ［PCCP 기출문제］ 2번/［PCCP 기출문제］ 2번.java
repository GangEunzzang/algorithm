import java.util.*;

class Solution {

    private int n; // 세로 x
    private int m; // 가로 y
    private int[] moveX = {-1, 1, 0, 0};
    private int[] moveY = {0, 0, -1, 1};
    private int[][] arr;
    private boolean[][] visited;
    private int depth = 1;
    private Map<Integer, Integer> maps = new HashMap<>();
    public int solution(int[][] land) {
        n = land.length; // x
        m = land[0].length; // y
        arr = land;
        visited = new boolean[n][m];

        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[j][i] && arr[j][i] == 1) {
                    bfs(j, i);
                }
            }
        }


        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (arr[j][i] >= 1) {
                    set.add(arr[j][i]);
                }
            }

            int sum = set.stream().mapToInt(num -> maps.get(num)).sum();

            answer = Math.max(answer, sum);

        }

        return answer;
    }

    private void bfs(int x, int y) {
        int result = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        arr[x][y] = depth;

        while (!q.isEmpty()) {
            Node node = q.poll();
            result++;

            for (int i = 0; i < 4; i++) {
                int mx = node.x + moveX[i];
                int my = node.y + moveY[i];
                if(mx < 0 || my < 0 || mx >= n || my >= m || visited[mx][my] || arr[mx][my] == 0) continue;
                q.add(new Node(mx, my));

                visited[mx][my] = true;
                arr[mx][my] = depth;
            }
        }

        maps.put(depth++, result);
    }

    private class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}