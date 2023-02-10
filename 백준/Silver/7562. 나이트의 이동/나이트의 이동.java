import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int map[][];
    static boolean[][] visited;

    static int endX;
    static int endY;

    static int I;

    static int count = 0;

    static int[] nX = {-1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] nY = {-2, -1, 1, 2, -2, -1, 1, 2 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs(firstX, firstY);

            sb.append(map[endX][endY]).append("\n");


        }
        System.out.println(sb);

    }

    static void bfs(int x, int y) {

        visited[x][y] = true;

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.add(x);
        queueY.add(y);

        while (!queueX.isEmpty()) {

            Integer pollX = queueX.poll();
            Integer pollY = queueY.poll();

            for (int i = 0; i < 8; i++) {
                int dataX = pollX + nX[i];
                int dataY = pollY + nY[i];

                if (dataX < 0 || dataY < 0 || dataX >= I || dataY >= I) {
                    continue;
                }

                
                if (!visited[dataX][dataY]) {
                    visited[dataX][dataY] = true;
                    queueX.add(dataX);
                    queueY.add(dataY);
                    map[dataX][dataY] = map[pollX][pollY] + 1;
                }

                if (dataX == endX && dataY == endY) {
                    return;
                }
            }


        }

    }
}
