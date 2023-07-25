import java.io.*;
import java.util.*;
public class Main {

    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int N;
    private static int min = Integer.MAX_VALUE;
    private static int minKevinBacon = Integer.MAX_VALUE;
    private static int kevinBacon;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(st.nextToken());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            kevinBacon = 0;
            visited[i] = true;
            bfs(i);
        }

        System.out.println(min);
    }

    private static void bfs(int search) {
        Queue<Friend> q = new LinkedList<>();
        q.add(new Friend(search, 0));

        while (!q.isEmpty()) {
            Friend friend = q.poll();
            int depth = friend.depth;
            int num = friend.num;
            kevinBacon += depth;

            List<Integer> list = graph.get(num);

            for (Integer i : list) {
                if (visited[i]) continue;
                visited[i] = true;
                q.add(new Friend(i, depth + 1));
            }
        }

        if (kevinBacon <  minKevinBacon) {
            min = search;
            minKevinBacon = kevinBacon;
        }

        if (kevinBacon == minKevinBacon) {
            min = Math.min(search, min);
        }

    }

    private static class Friend {
        int num;
        int depth;

        Friend(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}