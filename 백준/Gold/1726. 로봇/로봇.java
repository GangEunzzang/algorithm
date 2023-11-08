import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static int[][] arr;
    private static boolean[][][] visited;

    // 0 1 2 3 동 서 남 북
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static int M; // 세로
    private static int N; // 가로
    private static int[] arrivalPoint = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new boolean[M][N][4];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 출발 지점
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        int dir = Integer.parseInt(st.nextToken()) - 1;
        Robot robot = new Robot(x, y, dir, 0);

        // 도착 지점
        st = new StringTokenizer(br.readLine());
        arrivalPoint[0] = Integer.parseInt(st.nextToken()) - 1;
        arrivalPoint[1] = Integer.parseInt(st.nextToken()) - 1;
        arrivalPoint[2] = Integer.parseInt(st.nextToken()) - 1;

        bfs(robot);

    }


    private static void bfs(Robot robot) {
        Queue<Robot> q = new LinkedList<>();
        q.add(robot);
        visited[robot.x][robot.y][robot.dir] = true;

        while (!q.isEmpty()) {
            Robot now = q.poll();
            int x = now.x;
            int y = now.y;
            int dir = now.dir;
            int count = now.count;

            if (x == arrivalPoint[0] && y == arrivalPoint[1] && dir == arrivalPoint[2]) {
                System.out.println(count);
                System.exit(0);
            }

            // 현재 방향 전진 3칸
            for (int i = 1; i <= 3; i++) {
                int mx = x + moveX[dir] * i;
                int my = y + moveY[dir] * i;

                if (mx < 0 || my < 0 || mx >= M || my >= N || visited[mx][my][robot.dir]) continue;
                if (arr[mx][my] == 1) break;

                visited[mx][my][dir] = true;
                q.add(new Robot(mx, my, dir, count + 1));
            }

            // 방향 전환
            for (int i = 0; i < 4; i++) {
                if (dir == i || visited[x][y][i]) continue;
                visited[x][y][i] = true;

                if (isOppositeDir(dir, i)) {
                    q.add(new Robot(x, y, i, count + 2));
                } else {
                    q.add(new Robot(x, y, i, count + 1));
                }
            }
        }
    }

    private static boolean isOppositeDir(int curDir, int wantedDir) {
        if (curDir == 0 && wantedDir == 1) return true;
        if (curDir == 1 && wantedDir == 0) return true;
        if (curDir == 2 && wantedDir == 3) return true;
        if (curDir == 3 && wantedDir == 2) return true;

        return false;
    }

    private static class Robot {
        int x;
        int y;
        int dir;
        int count;

        public Robot(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
        }
    }

}