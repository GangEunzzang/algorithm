import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = toInt(st.nextToken());
        int M = toInt(st.nextToken());
        if (N == 0) {
            System.out.println(0);
            System.exit(0);
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = toInt(st.nextToken());
        }

        int result = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum > M) {
                result++;
                sum = arr[i];
            }
        }

        System.out.println(result);
    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}
