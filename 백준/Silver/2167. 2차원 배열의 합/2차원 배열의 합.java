import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = toInt(st.nextToken());
        int M = toInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = toInt(st.nextToken());
            }
        }



        int K = toInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = toInt(st.nextToken()) -1;
            int j = toInt(st.nextToken()) -1;
            int x = toInt(st.nextToken()) -1;
            int y= toInt(st.nextToken()) -1;
            
            int sum = 0;

            for (int a = i; a <= x; a++) {
                for(int b = j; b <= y; b++) {
                    sum += arr[a][b];
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }




    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}
