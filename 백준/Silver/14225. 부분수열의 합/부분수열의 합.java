import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] check = new boolean[2_000_001];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        int result = 0;
        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }

    static void dfs(int start, int sum) {
        check[sum] = true;

        for (int i = start; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(i, sum + arr[i]);
            visited[i] = false;
        }
    }


}
