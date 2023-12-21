import java.io.*;
import java.util.*;


public class Main {

    static int INF = 100_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, start, end;
    static int[] minCost;
    static boolean[] visited;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        minCost = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(minCost, INF);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = toInt(st.nextToken());
            int to = toInt(st.nextToken());
            int cost = toInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = toInt(st.nextToken());
        end = toInt(st.nextToken());

        bfs();


        System.out.println(minCost[end]);

    }

    static void bfs() {
        Queue<Node> q = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
        q.add(new Node(start, 0));
        minCost[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            List<Node> nxtList = graph.get(curNode.to);

            for (Node nxtNode : nxtList) {
                if (minCost[nxtNode.to] > curNode.cost + nxtNode.cost) {
                    minCost[nxtNode.to] = curNode.cost + nxtNode.cost;
                    q.add(new Node(nxtNode.to, minCost[nxtNode.to]));
                }
            }
        }


    }

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }




    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

