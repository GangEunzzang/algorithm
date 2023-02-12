import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();

    static int[] visited;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            graph.get(one).add(two);
            graph.get(two).add(one);
        }

        bfs(1);

        int max = 0;
        int index = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] > max) {
                index = i;
                max = visited[i];
            }
        }

        int finalMax = max;
        long count = Arrays.stream(visited).filter(a -> a == finalMax).count();

        StringBuilder sb = new StringBuilder();

        sb.append(index).append(" ");
        sb.append(visited[index]).append(" ");
        sb.append(count);

        System.out.println(sb);


    }

    static void bfs(int n) {

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        visit[n] = true;

        while (!q.isEmpty()) {

            Integer poll = q.poll();

            List<Integer> nodeList = graph.get(poll);

            for (Integer node : nodeList) {
                if (!visit[node]) {
                    visited[node] = visited[poll] + 1;
                    visit[node] = true;
                    q.add(node);
                }
            }
        }

    }


}
