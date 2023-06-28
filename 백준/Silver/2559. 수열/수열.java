import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = K - 1;
        int max = Arrays.stream(arr, 0, K).sum();

        int nowValue = max;

        while (start <= end) {
            if (++end >= N) break;

            nowValue -= arr[start++];
            nowValue += arr[end];

            max = Math.max(max, nowValue);
        }

        System.out.println(max);



    }

}