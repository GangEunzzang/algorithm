import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int K;
    private static boolean[] visited;

    private static int[] arr;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        visited[0] = true;
        System.out.println("NO");

    }

    static void dfs(int idx) {
        if (idx == N - 1) {
            System.out.print("YES");
            System.exit(0);
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i] && getCost(idx, i) <= K) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    static int getCost(int i, int j) {
        return (j - i) * (1 + Math.abs(arr[i] - arr[j]));
    }
}
