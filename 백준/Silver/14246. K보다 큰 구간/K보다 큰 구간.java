import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] sum = new long[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i -1] + Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());
        long count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (sum[j + 1] - sum[i] > k) count++;
            }
        }

        System.out.println(count);

    }
}