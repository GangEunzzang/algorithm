import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m,r;
    static int[] visited;
    static List<List<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visited = new int[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bfs();

        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        int seq = 1;
        visited[r] = seq++;

        while (!q.isEmpty()) {
            List<Integer> edgeList = graph.get(q.poll());

            Collections.sort(edgeList, Collections.reverseOrder());

            for (Integer node : edgeList) {
                if (visited[node] != 0) continue;
                visited[node] = seq++;
                q.add(node);
            }
        }
    }

}
