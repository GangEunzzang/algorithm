import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, max, answer;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = toInt(st.nextToken());
                arr[i][j] = cur;
                max = Math.max(cur, max);
                min = Math.min(cur, min);
            }
        }

        if (max == min) {
            System.out.println(1);
            return;
        }

        for (int i = min; i <= max; i++) {
            visited = new boolean[N][N];
            int areaCount = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] > i && !visited[j][k]) {
                        bfs(j,k,i);
                        areaCount++;
                    }
                }
            }

            answer = Math.max(areaCount, answer);
        }

        System.out.println(answer);
    }

    public static void bfs(int x, int y, int height) {
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nxtX = node.x + moveX[i];
                int nxtY = node.y + moveY[i];

                if (nxtX >= N || nxtY >= N || nxtX < 0 || nxtY < 0 || arr[nxtX][nxtY] <= height || visited[nxtX][nxtY]) continue;

                visited[nxtX][nxtY] = true;
                q.add(new Node(nxtX, nxtY));
            }
        }

    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}