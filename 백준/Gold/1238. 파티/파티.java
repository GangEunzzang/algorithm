import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,M,X;
    static List<List<Node>> list = new ArrayList<>();
    static List<List<Node>> reverseList = new ArrayList<>();
    static int[] distance;
    static int[] reverseDistance;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        X = toInt(st.nextToken());
        distance = new int[N + 1];
        reverseDistance = new int[N + 1];
        Arrays.fill(distance, INF);
        Arrays.fill(reverseDistance, INF);
        
        distance[X] = -1;
        reverseDistance[X] = -1;

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            int c = toInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            reverseList.get(b).add(new Node(a, c));
        }

        dijkstra(list, distance);
        dijkstra(reverseList, reverseDistance);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(distance[i] + reverseDistance[i], max);
        }

        System.out.println(max);
    }

    static void dijkstra(List<List<Node>> searchList, int[] searchDistance) {
        Queue<Node> q = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));
        q.add(new Node(X, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node next : searchList.get(cur.to)) {
                if (searchDistance[next.to] > cur.cost + next.cost) {
                    searchDistance[next.to] = cur.cost + next.cost;
                    q.add(new Node(next.to, cur.cost + next.cost));
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



