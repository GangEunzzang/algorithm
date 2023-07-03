import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int K;
    private static int[] arr;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        System.out.println(count);

    }

    private static void dfs(int idx, int sum) {
        if (sum < 500) return;
        if (idx == N) {
            if (sum >= 500) count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(idx + 1, sum + arr[i] - K);
            visited[i] = false;
        }
    }
}