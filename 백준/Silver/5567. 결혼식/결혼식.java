import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static int N;
    private static List<List<Integer>> friendship = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            friendship.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            friendship.get(a).add(b);
            friendship.get(b).add(a);
        }

        visited[0] = true;
        dfs(0, 0);

        int count = 0;

        for (int i = 1; i < N; i++) {
            if (visited[i]) count++;
        }

        System.out.println(count);

    }

    private static void dfs(int n, int depth) {

        if (depth == 2) return;

        for (Integer i : friendship.get(n)) {
            visited[i] = true;
            dfs(i, depth + 1);
        }

    }
}