import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] prohibition = new boolean[N + 1][N + 1];
        int count = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            prohibition[x][y] = true;
            prohibition[y][x] = true;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    if (prohibition[i][j] || prohibition[i][k] || prohibition[j][k]) {
                        continue;
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}