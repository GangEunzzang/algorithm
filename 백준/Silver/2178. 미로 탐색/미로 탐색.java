import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int graph[][];

    static boolean visited[][];

    static int N;
    static int M;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                graph[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        bfs();
        System.out.println(graph[N - 1][M - 1]);
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < N; i++) {
//
//            sb.append("[");
//            for (int j = 0; j < M; j++) {
//                sb.append(graph[i][j]).append(" ");
//            }
//
//            sb.append("]").append("\n");
//        }
//
//        System.out.println(sb);
    }

    static void bfs() {

        Queue<Integer> queueOfX = new LinkedList<>();
        Queue<Integer> queueOfY = new LinkedList<>();

        queueOfX.offer(0);
        queueOfY.offer(0);

        visited[0][0] = true;

        while (!queueOfX.isEmpty()) {

            Integer x = queueOfX.poll();
            Integer y = queueOfY.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                        queueOfX.offer(nx);
                        queueOfY.offer(ny);

                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[x][y] + 1;
                    }
                }

            }

        }


    }
}
