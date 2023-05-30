import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i) == 'P' ? 1 : 0;
        }

        int count = 0;

        first:
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0 || arr[i] == -1) continue;

            int startIdx = Math.max(i - K, 0);
            int endIdx = Math.min(i + K, N - 1);

            for (int j = startIdx; j <= endIdx ; j++) {
                if (arr[j] == 0) {
                    arr[j] = -1;
                    count++;
                    continue first;
                }
            }
        }


        System.out.println(count);
    }
}