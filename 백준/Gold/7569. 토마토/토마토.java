import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int M;
    private static int N;
    private static int H;
    private static int[][][] arr;
    private static int max;
    private static boolean[][][] visited;
    private static boolean zero = true;
    private static int[] moveX = {1, -1 ,0, 0, 0 ,0};
    private static int[] moveY = {0, 0, -1, 1, 0, 0};
    private static int[] moveZ = {0, 0, 0, 0, -1 ,1};
    private static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[N][M][H];
        visited = new boolean[N][M][H];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());

                    if (num == 1) q.add(new Node(i, j, k, 0));
                    if (num == 0) zero = false;

                    arr[i][j][k] = num;
                }
            }
        }

        if (zero) {
            System.out.println(0);
            return;
        }

        bfs();

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, arr[i][j][k]);
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int z = node.z;
            int count = node.count;

            visited[x][y][z]= true;

            for (int i = 0; i < 6; i++) {

                int nx = x + moveX[i];
                int ny = y + moveY[i];
                int nz = z + moveZ[i];

                if (nx < 0 || ny < 0 ||  nz < 0 || nx >= N || ny >= M || nz >= H || visited[nx][ny][nz]) continue;

                if (arr[nx][ny][nz] == 0){
                    arr[nx][ny][nz] = count + 1;
                    q.add(new Node(nx, ny,nz, count + 1));
                    visited[nx][ny][nz] = true;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int z;
        int count;

        Node(int x, int y,int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}
