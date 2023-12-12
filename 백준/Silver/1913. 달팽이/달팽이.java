import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int N, search;
    static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        search = toInt(br.readLine());
        arr = new int[N][N];
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length()-1));
        System.out.println(result[0] + " " + result[1]);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        arr[0][0] = N * N;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int dir = node.dir;
            int x = node.x;
            int y = node.y;

            if (arr[x][y] == search) {
                result[0] = x+1;
                result[1] = y+1;
            }

            int mx = x + moveX[dir];
            int my = y + moveY[dir];

            if (mx < 0 || my < 0 || mx >= N || my >= N || arr[mx][my] != 0) {
                if (++dir == 4) dir = 0;
                mx = x + moveX[dir];
                my = y + moveY[dir];
            }

            if (arr[mx][my] == 0) {
                q.add(new Node(x + moveX[dir], y + moveY[dir], dir));
                arr[x + moveX[dir]][y + moveY[dir]] = arr[x][y] - 1;
            }
        }
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

    static class Node {
        int x;
        int y;
        int dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }


}
