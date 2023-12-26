import java.io.*;
import java.util.*;


public class Main {

    static int D = -2;
    static int stone = -1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int R, C, answer;
    static int[][] arr;
    static boolean[][] visited;
    static int[] startPoint = new int[2];
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = toInt(st.nextToken());
        C = toInt(st.nextToken());
        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'S') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                    arr[i][j] = -3;
                }
                if (s.charAt(j) == '.') arr[i][j] = 0;
                if (s.charAt(j) == '*') arr[i][j] = 1;
                if (s.charAt(j) == 'X') arr[i][j] = stone;
                if (s.charAt(j) == 'D') arr[i][j] = D;
            }
        }

        waterDiffuse();
        System.out.println(bfs() ? answer : "KAKTUS");
    }

    private static boolean bfs() {
        visited = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(startPoint[0], startPoint[1], 2));
        visited[startPoint[0]][startPoint[1]] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (arr[node.x][node.y] == D) {
                answer = node.count - 2;
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int mx = node.x + moveX[i];
                int my = node.y + moveY[i];

                if (mx < 0 || my < 0 || mx >= R || my >= C || visited[mx][my]) continue;
                if (arr[mx][my] == stone || (arr[mx][my] <= node.count && arr[mx][my] > 0)) continue;

                q.add(new Node(mx, my, node.count + 1));
                visited[mx][my] = true;
            }
        }

        return false;

    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }


    static void waterDiffuse() {
        visited = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 1) {
                    q.add(new Node(i, j, 1));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = node.x + moveX[i];
                int my = node.y + moveY[i];

                if (mx < 0 || my < 0 || mx >= R || my >= C || visited[mx][my] || arr[mx][my] < 0) continue;

                q.add(new Node(mx, my, node.count + 1));
                arr[mx][my] = node.count + 1;
                visited[mx][my] = true;
            }
        }
    }


    static class Node {
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



