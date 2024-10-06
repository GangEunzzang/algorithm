import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = toInt(st.nextToken());
        int M = toInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = toInt(st.nextToken()) + arr[i][j - 1];
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = toInt(st.nextToken());
            int y1 = toInt(st.nextToken());
            int x2 = toInt(st.nextToken());
            int y2 = toInt(st.nextToken());

            int sum = 0;

            for (int i = x1; i <= x2; i++) {
                sum += arr[i][y2] - arr[i][y1 - 1];
            }


            sb.append(sum).append("\n");
        }

        System.out.println(sb);

//        2,2  3,4
//        [2][2]  ~ [2][4]
//        [3][2] ~ [3][4]
//
//        [2][4] + [3][4] - [2][1] - [3][1]

    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
