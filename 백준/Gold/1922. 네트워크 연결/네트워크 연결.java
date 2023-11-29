import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static List<Node> list = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, c));
        }

        Collections.sort(list);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);

            if (find(node.e) != find(node.v)) {
                union(node.e, node.v);
                sum += node.val;
            }
        }


        System.out.println(sum);
    }

    static int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    static class Node implements Comparable<Node> {
        int v;
        int e;
        int val;

        Node(int v, int e, int val) {
            this.v = v;
            this.e = e;
            this.val = val;
        }


        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }
    }





}