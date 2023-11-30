import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static String bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (arr[node.x][node.y] == -1) {
                return "HaruHaru";
            }


            int rightMx = node.x + arr[node.x][node.y];
            int rightMy = node.y;

            int underMx = node.x;
            int underMy = node.y + arr[node.x][node.y];

            if (rightMx >= 0 && rightMy >= 0 && rightMx < N && rightMy < N && !visited[rightMx][rightMy]) {
                visited[rightMx][rightMy] = true;
                q.add(new Node(rightMx, rightMy));
            }

            if (underMx >= 0 && underMy >= 0 && underMx < N && underMy < N && !visited[underMx][underMy]) {
                visited[underMx][underMy] = true;
                q.add(new Node(underMx, underMy));
            }

        }

        return "Hing";
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