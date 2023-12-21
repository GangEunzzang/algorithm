import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, answer;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] moveY = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = toInt(st.nextToken());
                arr[i][j] = height;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                bfs(i, j);
            }
        }



        System.out.println(answer);
    }

    static void bfs(int startX, int startY) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY));
        visited[startX][startY] = true;

        boolean flag = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 8; i++) {
                int mx = node.x + moveX[i];
                int my = node.y + moveY[i];

                if (mx < 0 || my < 0 || mx >= N || my >= M ) continue;
                if (arr[node.x][node.y] < arr[mx][my]) flag = false;

                if (!visited[mx][my] && arr[node.x][node.y] == arr[mx][my]) {
                    q.add(new Node(mx, my));
                    visited[mx][my] = true;
                }

            }
        }

        if (flag) answer++;
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

