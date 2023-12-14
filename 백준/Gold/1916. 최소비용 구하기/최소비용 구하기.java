import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, start ,end;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] minCosts;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        M = toInt(br.readLine());
        minCosts = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            minCosts[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            int cost = toInt(st.nextToken());
            graph.get(a).add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = toInt(st.nextToken());
        end = toInt(st.nextToken());
        bfs();

        System.out.println(minCosts[end]);
    }

    static void bfs() {
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            List<Node> list = graph.get(curNode.idx);
            minCosts[curNode.idx] = Math.min(minCosts[curNode.idx], curNode.cost);

            if (visited[curNode.idx]) continue;
            visited[curNode.idx] = true;

            for (Node nextNode : list) {
                if (minCosts[nextNode.idx] >= curNode.cost + nextNode.cost) {
                    minCosts[nextNode.idx] = curNode.cost + nextNode.cost;
                    pq.add(new Node(nextNode.idx, curNode.cost + nextNode.cost));
                }
            }
        }

    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }


}

