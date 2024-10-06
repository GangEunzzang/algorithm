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
        int N = toInt(br.readLine());
        int[][] arr = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = toInt(st.nextToken());
            arr[i][1] = toInt(st.nextToken());
            arr[i][2] = toInt(st.nextToken());
        }

        for (int i = 1; i <= N ; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(arr[N][0], arr[N][1]), arr[N][2]));
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
