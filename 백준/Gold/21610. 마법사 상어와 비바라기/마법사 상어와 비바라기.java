import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int direction;
    private static int number;
    private static int[][] arr;
    private static boolean[][] visited;
    private static List<Node> rainCloudList;
    private static int[] moveX = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] moveY = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];

        rainCloudList = List.of(
                new Node(N, 1),
                new Node(N, 2),
                new Node(N - 1, 1),
                new Node(N - 1, 2)
        );

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            visited = new boolean[N + 1][N + 1];
            direction = Integer.parseInt(st.nextToken()); // 이동 방향
            number = Integer.parseInt(st.nextToken());  // 횟수

            rainCloudMove();
            waterCopy();
            searchRainCloud();

        }

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) sum += arr[i][j];
        }

        System.out.println(sum);

        /**
         * 처음 시작하는 구름 위치는  (N, 1), (N, 2), (N-1, 1), (N-1, 2)
         * 지정한 방향의 횟수만큼 이동 (%로 처리)
         * 이동 후 비구름이 있는 애들은 물의 양 1씩 증가
         * 구름이 모두 사라짐
         * 물이 증가한 칸에서만 (list 로 보관) 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r,c)에 있는 바구니의 물의 양이 증가
         * list에 보관된 애들을 제외한 물의 양이 2이상인 모든 칸에 구름이 생기고, 물의 양이 2가 줄어듦
         * M번 반복
         *
         */

    }

    private static void waterCopy() {
        Queue<Node> q = new LinkedList<>(rainCloudList);

        while (!q.isEmpty()) {
            Node node = q.poll();

            int sum = 0;

            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) continue;

                int nx = node.x + moveX[i];
                int ny = node.y + moveY[i];

                if (nx >= 0 && ny >= 0 && nx <= N && ny <= N && arr[nx][ny] > 0) sum++;
            }

            arr[node.x][node.y] += sum;

        }
    }

    static void searchRainCloud() {
        rainCloudList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] >= 2 && !visited[i][j]) {
                    arr[i][j] -= 2;
                    rainCloudList.add(new Node(i, j));
                }
            }
        }
    }

    static void rainCloudMove() {
        for (Node node : rainCloudList) {
            int nx = node.x;
            int ny = node.y;
            
            for (int i = 0; i < number; i++) {
                nx = nx + moveX[direction - 1];
                ny = ny + moveY[direction - 1];

                if (nx > N) nx = 1;
                if (nx < 1) nx = N;

                if (ny > N) ny = 1;
                if (ny < 1) ny = N;
            }

            node.x = nx;
            node.y = ny;

            arr[nx][ny]++;

            visited[node.x][node.y] = true;
        }
    }


    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }


}
