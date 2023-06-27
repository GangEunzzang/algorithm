import java.io.*;
import java.util.*;

public class Main {

    private static char[][] map = new char[12][6];
    private static boolean[][] visited;
    private static List<Node> boomList = new ArrayList<>();
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, -1, 1};
    private static boolean isFinished;
    private static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        while (!isFinished) {
            isFinished = true;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if (!isFinished) answer++;
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        boomList.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = moveX[i] + node.x;
                int my = moveY[i] + node.y;

                if (mx < 0 || my < 0 || mx >= 12 || my >= 6 || map[mx][my] == '.' || visited[mx][my]) continue;

                if (map[node.x][node.y] == map[mx][my]) {
                    q.add(new Node(mx, my));
                    visited[mx][my] = true;
                    boomList.add(new Node(mx, my));
                }
            }
        }

        if (boomList.size() >= 4) {
            for (Node node : boomList) map[node.x][node.y] = '.';
            isFinished = false;
            dropDown();
        }

        boomList = new ArrayList<>();
    }

    private static void dropDown() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                if(map[j][i] != '.') continue;

                for (int k = j - 1; k >= 0; k--) {
                    if (map[k][i] != '.') {
                        map[j][i] = map[k][i];
                        map[k][i] = '.';
                        break;
                    }
                }

            }
        }
    }

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}