import java.io.*;
import java.util.*;


public class Main {

    static int INF = 2_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, start, target;
    static int[] minCost, visited;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        M = toInt(br.readLine());

        minCost = new int[N + 1];
        visited = new int[N + 1];

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
        }

        st = new StringTokenizer(br.readLine());
        start = toInt(st.nextToken());
        target = toInt(st.nextToken());

        bfs();

        sb.append(minCost[target] + "\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(target);

        while (visited[target] != 0) {
            stack.push(visited[target]);
            target = visited[target];
        }

        sb.append(stack.size() + "\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);


    }

    static void bfs() {
        Queue<Node> q = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
        q.add(new Node(start, 0));
        minCost[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            
            if (minCost[curNode.to] < curNode.cost) continue;
            
            for (Node nxtNode : graph.get(curNode.to)) {
                if (minCost[nxtNode.to] > curNode.cost + nxtNode.cost) {
                    minCost[nxtNode.to] = curNode.cost + nxtNode.cost;
                    q.add(new Node(nxtNode.to, minCost[nxtNode.to]));
                    visited[nxtNode.to] = curNode.to;
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

