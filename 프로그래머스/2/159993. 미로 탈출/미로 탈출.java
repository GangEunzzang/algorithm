import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    // 시작지점, 출구, 레버, 통로, 벽
    int[] start = new int[2];
    int[] lever = new int[2];
    char[][] arr;
    boolean[][] visited;
    int N,M;
    int[] moveX = {-1, 1, 0, 0};
    int[] moveY = {0, 0, -1, 1};

    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        arr = new char[N][M];

        for (int i = 0; i < maps.length; i++) {
            char[] charArray = maps[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                char c = charArray[j];
                arr[i][j] = c;

                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;
                }

                if (c == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        int leverSearchCount = searchOfTarget('L', start[0], start[1]);
        if (leverSearchCount == -1) return -1;

        int exitSearchCount = searchOfTarget('E', lever[0], lever[1]);
        if (exitSearchCount == -1) return -1;
        
        return leverSearchCount + exitSearchCount;
    }

    int searchOfTarget(char target, int startX, int startY) {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[N][M];
        visited[startX][startY] = true;
        q.add(new Node(startX, startY, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (arr[cur.x][cur.y] == target) return cur.count;

            for (int i = 0; i < 4; i++) {
                int mx = cur.x + moveX[i];
                int my = cur.y + moveY[i];
                if (mx < 0 || my < 0 || mx >= N || my >= M || arr[mx][my] == 'X' || visited[mx][my]) continue;
                visited[mx][my] = true;
                q.add(new Node(mx, my, cur.count + 1));
            }
        }

        return -1;
    }

    class Node {
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