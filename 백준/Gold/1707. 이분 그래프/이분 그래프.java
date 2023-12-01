import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int K;
    static int[] color;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean isBipartiteGraph;

    public static void main(String[] args) throws IOException {

        K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            color = new int[V + 1];

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            isBipartiteGraph = true;

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0 && isBipartiteGraph) {
                    bfs(i);
                }
            }

            sb.append(isBipartiteGraph ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1;

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for (Integer next : graph.get(cur)) {
                if (color[cur] == color[next]) {
                    isBipartiteGraph = false;
                    return;
                }

                if (color[next] == 0) {
                    color[next] = color[cur] * -1;
                    q.add(next);
                }


            }
        }
    }

}
