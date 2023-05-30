import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int N;
    private static boolean visited[][];
    private static int[] moveX = {-2, -2, 0, 0, 2, 2};
    private static int[] moveY = {-1, 1, -2, 2, -1, 1};

    private static int startX;
    private static int startY;
    private static int targetX;
    private static int targetY;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        targetX = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(-1);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int count = node.count;

            if (x == targetX && y == targetY) {
                System.out.println(count);
                System.exit(0);
            }

            for (int i = 0; i < 6; i++) {
                int mx = moveX[i] + x;
                int my = moveY[i] + y;

                if(mx < 0 || my < 0 || mx >= N || my >= N || visited[mx][my]) continue;
                visited[mx][my] = true;

                q.add(new Node(mx, my, count + 1));

            }

        }
    }

    static class Node {
        int x;
        int y;
        int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


}

