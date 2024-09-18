import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = toInt(st.nextToken());
        int K = toInt(st.nextToken());
        int max = 0;

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] += arr[i - 1] + toInt(br.readLine());
            if (i < K) continue;
            int sum = arr[i] - arr[i - K];
            if (max < sum) max = sum;
        }

        System.out.println(max);
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}