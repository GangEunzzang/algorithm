import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, M, 1);
        System.out.println(max);
    }

    private static void dfs(int idx, int time, int size) {
        if (time == 0 || idx >= N) {
            max = Math.max(size, max);
            return;
        }

        if (idx < N) dfs(idx + 1, time - 1, size + arr[idx + 1]);
        if (idx < N - 1) dfs(idx + 2, time - 1, size / 2 + arr[idx + 2]);
    }

}
