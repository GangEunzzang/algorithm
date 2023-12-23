import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] arr;
    static int N;
    static boolean flag;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, 0);

        System.out.println(flag ? "YES" : "NO");

    }


    static void dfs(int hurdleCount, int x, int y) {
        if (flag) return;

        if (hurdleCount == 3) {
            check();
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = y; j < N; j++) {
                if (arr[i][j] != 'X') continue;
                arr[i][j] = 'O';
                dfs(hurdleCount + 1, i, j +1);
                arr[i][j] = 'X';
            }
            y = 0;
        }

    }

    static void check() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'T') {
                    q.add(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int idx = 1;
                while (true) {
                    int mx = node.x + moveX[i] * idx;
                    int my = node.y + moveY[i] * idx++;
                    if(mx < 0 || my < 0 || mx >= N || my >= N || arr[mx][my] == 'O') break;
                    if (arr[mx][my] == 'S') return;
                }
            }
        }

        flag = true;
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