import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = toInt(st.nextToken());
        }

        long max = Arrays.stream(arr, 0, M).sum();
        long now = max;

        for (int i = M; i < N; i++) {
            now -= arr[i - M];
            now += arr[i];
            max = Math.max(now, max);
        }

        System.out.println(max);

    }

    static long toInt(String val) {
        return Long.parseLong(val);
    }




}

