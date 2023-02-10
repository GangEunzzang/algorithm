import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] square;
    static boolean[][] visited;

    static int M;
    static int N;

    static int count = 0;

    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        square = new int[M][N];
        visited = new boolean[M][N];

        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());

            int leftX = Integer.parseInt(st.nextToken());  // 0  -> 2
            int leftY = Integer.parseInt(st.nextToken());  // 2   -> 0
            int rightX = Integer.parseInt(st.nextToken()); // 4   -> 3
            int rightY = Integer.parseInt(st.nextToken()); // 4  -> 3

            // x, y 뒤집고   right는 x, y 뒤집고 1씩 뺌 !

            for (int j = leftY; j < rightY  ; j++) {

                for (int k = leftX ; k < rightX ; k++) {
                    square[j][k] = 1;
                }
            }
        }



        List<Integer> list = new ArrayList<>();
        int number = 0;

        for (int i = 0; i < M; i++) {

            for (int j = 0; j < N; j++) {

                if (square[i][j] == 0 && !visited[i][j]) {
                    count = 0;
                    dfs(i,j);
                    list.add(count);
                    number ++;
                }

            }

        }

        Collections.sort(list);

        System.out.println(number);

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);

    }

    static void dfs(int a, int b) {

        visited[a][b] = true;
        count++;

        for (int i = 0; i < 4; i++) {

            int X = a + nx[i];
            int Y = b + ny[i];

            if (X < 0 || Y < 0 || X >= M || Y >= N) {
                continue;
            }

            if (square[X][Y] == 0 && !visited[X][Y]) {
                dfs(X, Y);
            }

        }

    }

}
