import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = toInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        first:
        while (T-- > 0) {
            int N = toInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = toInt(st.nextToken());
            }

            arr[0] = Math.min(N - arr[0] + 1, arr[0]);

            for (int i = 1; i < N; i++) {
                int cur = N - arr[i] + 1;
                int max = Math.max(arr[i], cur);
                int min = Math.min(arr[i], cur);

                if (min < arr[i-1] && max < arr[i-1]) {
                    sb.append("NO").append("\n");
                    continue first;
                }

                if (min >= arr[i - 1]) {
                    arr[i] = min;
                } else {
                    arr[i] = max;
                }
            }

            sb.append("YES").append("\n");
        }

        System.out.println(sb);


    }

    private static int toInt(String str) {
        return Integer.parseInt(str);
    }

}
