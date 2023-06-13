import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int L;
    private static int R;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] moveX = {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, -1, 1};
    private static List<Node> list;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(answer);

    }

    static void solve() {
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;
                    int bfs = bfs(i, j);
                    if (list.size() > 1) {
                        changeValue(bfs);
                        isMove = true;
                    }
                }
            }

            if(!isMove) break;
            answer++;
        }
    }

    static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();
        list.add(new Node(r, c));
        q.add(new Node(r, c));
        int sum = arr[r][c];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int mx = x + moveX[i];
                int my = y + moveY[i];

                if(mx < 0 || my < 0 || mx >= N || my >= N || visited[mx][my]) continue;

                int diff = Math.abs(arr[mx][my] - arr[x][y]);
                if (diff >= L && diff <= R) {
                    q.add(new Node(mx, my));
                    list.add(new Node(mx, my));
                    sum += arr[mx][my];
                    visited[mx][my] = true;
                }
            }
        }

        return sum;
    }

    static void changeValue(int sum) {
        for (Node node : list)
            arr[node.x][node.y] = sum / list.size();
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
